package com.qfedu.hr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 需要代理的方法有
 * getParameter
 * getParameterValues
 * getParameterMap
 *
 * @author ZZzz
 */
//@WebFilter("/*")
public class BSensitiveWordFilter implements Filter {
    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //使用init方法读取保存在双人床路径下的SensitiveWord.txt

        ServletContext servletContext = filterConfig.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/SensitiveWord.txt");

        try {
            //读取文件，采用BufferedRead 字符输入流缓冲
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));

            String line = null;

            //读取文件中的敏感字符，并保存到List集合中
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 强制转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 2. 创建代理对象，并且强转为HttpServletRequest对象
        HttpServletRequest proxyRequest = (HttpServletRequest) Proxy.newProxyInstance(
                request.getClass().getClassLoader(),
                request.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 增强getParameter方法
                        if ("getParameter".equals(method.getName())) {
                            // 获取原本的返回的数据
                            String value = (String) method.invoke(request, args);

                            // 判断 value 中是否包含敏感字符
                            if (value != null) {
                                // 遍历敏感字 List集合
                                for (String s : list) {
                                    // 如果 当前value中包含敏感词，替换内容
                                    if (value.contains(s)) {
                                        value = value.replaceAll(s, "***");
                                    }
                                }
                            }

                            return value;
                        }

                        /*
                        String[] getParameterValues(String name)
                        传入参数是 指定参数的名字
                        返回值类型是String类型字符串，如果没有对应的值，返回null
                         */
                        if ("getParameterValues".equals(method.getName())) {

                            // 获取原本数据的数据数组
                            String[] values = (String[]) method.invoke(request, args);

                            // 判断数组不为 null
                            if (values != null) {
                                // 遍历 List 敏感字集合
                                for (String s : list) {
                                    // 遍历原数据数组
                                    for (int i = 0; i < values.length; i++) {
                                        // 如果 当前原数组下标 i的元素中包含敏感词，替换内容
                                        if (values[i].contains(s)) {
                                            values[i] = values[i].replaceAll(s, "***");
                                        }
                                    }
                                }
                            }

                            return values;

                        }

                        /*
                        Map<String, String[]> getParameterMap();
                        返回值所有参数的 Map双边队列
                        键 是参数的名字，参数的键
                        值 是参数的值
                        如果没有数据，不是返回null，而是返回一个map.size() == 0 的一个 Map对象
                        */
                        if ("getParameterMap".equals(method.getName())) {
                            // 获取请求所有参数的 Map 双边队列对象
                            Map<String, String[]> parameterMap = (Map<String, String[]>) method.invoke(request, args);

                            // 如果参数 Map双边对象中的size 为 0，处理数据
                            if (parameterMap.size() != 0) {

                                // 获取 Map 双边队列的 Entry 键值对对象 Set集合
                                Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
                                // 遍历 键值对对象 Set集合
                                for (Map.Entry<String, String[]> entry : entries) {
                                    // 取值当前遍历 值数组
                                    String[] value = entry.getValue();

                                    // 遍历敏感字List集合
                                    for (String s : list) {

                                        // 使用 for i 循环 遍历 值数组
                                        for (int i = 0; i < value.length; i++) {
                                            // 如果当前值数组下标为 i 的元素包含的 敏感字 替换
                                            if (value[i].contains(s)) {
                                                value[i] = value[i].replaceAll(s, "***");
                                            }
                                        }
                                    }
                                }
                            }

                            return parameterMap;

                        }
                        // 如果不是获取参数的方法，正常执行
                        return method.invoke(request, args);
                    }
                });

        // 放行！！！ 放行的对象是代理对象，代理对象中的方法，已经被增强了
        filterChain.doFilter(proxyRequest, response);
    }

    @Override
    public void destroy() {

    }

}