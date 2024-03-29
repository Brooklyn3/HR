`
<%--
  Created by IntelliJ IDEA.
  User: 城南邮局
  Date: 2019/7/4
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        @font-face {
            font-family: 'iconfont';
            src: url('//at.alicdn.com/t/font_1463147324_946932.eot'); /* IE9*/
            src: url('//at.alicdn.com/t/font_1463147324_946932.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
            url('http://at.alicdn.com/t/font_1463147324_946932.woff') format('woff'), /* chrome、firefox */
            url('http://at.alicdn.com/t/font_1463147324_946932.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
            url('//at.alicdn.com/t/font_1463147324_946932.svg#iconfont') format('svg'); /* iOS 4.1- */
        }

        *{margin: 0;padding: 0}
        li{list-style: none;}
        form a{text-decoration: none;}
        html,body {
            background: #fff;
            width: 100%;
            height: 100%;
            display: flex;
            flex-flow: column nowrap;
            justify-content: center;
        }
        .wrapper{text-align: center;}
        .header{
            font-size: 25px;
            font-family: 微软雅黑;
            color: rgb(98,94,91);
        }
        .header span{
            font-size: 30px;
            font-family: "Brush Script Std";
        }
        form{
            /*background: url(input-bg.png);*/
            width: 260px;
            height: 260px;
            margin: 35px auto;
            padding: 30px;
            box-shadow:0px 1px 2px 1px #aaaaaa,
            inset 0px 1px 1px rgba(255,255,255,0.7);
            border-radius: 3px;
        }
        form ul{
            width: 100%;
            height: 100%;
            text-align: left;
            display: flex;
            flex-flow: column nowrap;
            justify-content: space-between;
        }
        ul li div{
            width: 260px;
            height: 40px;
            background: #e1dcd8;
            color: rgb(98,94,91);
            box-shadow: inset 0px 2px 5px #aaaaaa;
            border-radius: 5px;
            position: relative;
        }
        ul li .yonghu{
            font-family: iconfont;
            position: absolute;
            top: 12px;
            left: 10px;
        }
        ul li .mima{
            font-family: iconfont;
            position: absolute;
            top: 12px;
            left: 10px;
        }
        ul li div input{
            height: 40px;
            width: 190px;
            padding: 0 35px;
            border: none;
            background: #e1dcd8;
            color: rgb(98,94,91);
            box-shadow:
                    0px 1px 1px rgba(255,255,255,0.7),
                    inset 0px 2px 5px #aaaaaa;
            border-radius: 5px;
        }
        ul li input:focus{
            outline: none;
            background: #f5f2ef;
        }
        ul .remember{
            font-size: 14px;
            font-family: 微软雅黑;
            font-weight: bold;
            color: rgb(98,94,91);
            position: relative;
            display: flex;
            justify-content: center;
        }
        ul .remember input[type*="checkbox"]{
            width: 20px;
            height: 20px;
            vertical-align: super;
            margin-right: 12px;
        }
        .remember label {
            cursor: pointer;
            position: absolute;
            width: 22px;
            height: 22px;
            top: 7px;
            left: 0;
            background: #eee;
            border:1px solid #cccccc;
            border-radius: 4px;

        }
        /*Display the tick inside the checkbox*/
        .remember label:after {
            opacity: 0.4;
            content: '';
            position: absolute;
            width: 12px;
            height: 5px;
            background: transparent;
            top: 6px;
            left: 4px;
            border: 3px solid #74884a;
            border-top: none;
            border-right: none;

            -webkit-transform: rotate(-45deg);
            -moz-transform: rotate(-45deg);
            -o-transform: rotate(-45deg);
            -ms-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }
        /*Create the hover event of the tick*/
        .remember label:hover::after {
            opacity: 0.7;
        }
        /*Create the checkbox state for the tick*/
        .remember input[type=checkbox]:checked + label:after {
            opacity: 1;
            border-color: #74884a;
        }
        ul li a{
            font-size: 14px;
            font-family: 黑体;
            color: rgb(152,142,135);
            display: flex;
            justify-content: center;
        }
        ul li input[type*="button"]{
            width: 100%;
            height: 40px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 18px;
            color: #ffffff;
            background: -moz-linear-gradient(
                    top,
                    #94aa64 0%,
                    #7a924a 50%,
                    #607738);
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#94aa64),
                    color-stop(0.50, #7a924a),
                    to(#607738));
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            border: 1px solid #7d8862;
            -moz-box-shadow:
                    0px 1px 0px rgba(170,170,170,1),
                    inset 0px 1px 1px rgba(255,255,255,0.7);
            -webkit-box-shadow:
                    0px 1px 0px rgba(170,170,170,1),
                    inset 0px 1px 1px rgba(255,255,255,0.7);
            box-shadow:
                    0px 1px 0px rgba(170,170,170,1),
                    inset 0px 1px 1px rgba(255,255,255,0.7);
            text-shadow:
                    0px -1px 0px rgba(000,000,000,0.3),
                    0px 0px 0px rgba(255,255,255,0);
        }
        ul li input[type*="button"]:hover{
            opacity: 0.8;
        }
        ul li input[type*="button"]:active{
            width: 100%;
            height: 40px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 18px;
            color: #ffffff;
            background: -moz-linear-gradient(
                    top,
                    #607738 0%,
                    #7a924a 50%,
                    #94aa64 );
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#607738),
                    color-stop(0.50, #7a924a),
                    to(#94aa64));
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            border: 1px solid #7d8862;
            -moz-box-shadow:
                    0px -1px 0px rgba(170,170,170,1),
                    inset 0px -1px 1px rgba(255,255,255,0.7);
            -webkit-box-shadow:
                    0px -1px 0px rgba(170,170,170,1),
                    inset 0px -1px 1px rgba(255,255,255,0.7);
            box-shadow:
                    0px -1px 0px rgba(170,170,170,1),
                    inset 0px -1px 1px rgba(255,255,255,0.7);
            text-shadow:
                    0px 1px 0px rgba(000,000,000,0.3),
                    0px 0px 0px rgba(255,255,255,0);
        }

        ul li input[type*="submit"]{
            width: 100%;
            height: 40px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 18px;
            color: #ffffff;
            background: -moz-linear-gradient(
                    top,
                    #94aa64 0%,
                    #7a924a 50%,
                    #607738);
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#94aa64),
                    color-stop(0.50, #7a924a),
                    to(#607738));
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            border: 1px solid #7d8862;
            -moz-box-shadow:
                    0px 1px 0px rgba(170,170,170,1),
                    inset 0px 1px 1px rgba(255,255,255,0.7);
            -webkit-box-shadow:
                    0px 1px 0px rgba(170,170,170,1),
                    inset 0px 1px 1px rgba(255,255,255,0.7);
            box-shadow:
                    0px 1px 0px rgba(170,170,170,1),
                    inset 0px 1px 1px rgba(255,255,255,0.7);
            text-shadow:
                    0px -1px 0px rgba(000,000,000,0.3),
                    0px 0px 0px rgba(255,255,255,0);
        }
        ul li input[type*="submit"]:active{
            width: 100%;
            height: 40px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 18px;
            color: #ffffff;
            background: -moz-linear-gradient(
                    top,
                    #607738 0%,
                    #7a924a 50%,
                    #94aa64 );
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#607738),
                    color-stop(0.50, #7a924a),
                    to(#94aa64));
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            border: 1px solid #7d8862;
            -moz-box-shadow:
                    0px -1px 0px rgba(170,170,170,1),
                    inset 0px -1px 1px rgba(255,255,255,0.7);
            -webkit-box-shadow:
                    0px -1px 0px rgba(170,170,170,1),
                    inset 0px -1px 1px rgba(255,255,255,0.7);
            box-shadow:
                    0px -1px 0px rgba(170,170,170,1),
                    inset 0px -1px 1px rgba(255,255,255,0.7);
            text-shadow:
                    0px 1px 0px rgba(000,000,000,0.3),
                    0px 0px 0px rgba(255,255,255,0);
        }

        .footer{
            font-size: 12px;
            font-family: 黑体;
            color: rgb(98,94,91);
        }
        .footer a{
            color: rgb(152,142,135);
        }
    </style>
</head>
<body>
<div class="wrapper">
    <div class="header">Login to <span>iyaq</span></div>
    <form action="LoginServlet?method=userServlet" method="post">
        <ul>
            <li>
                <div class="text">
                    <span class="yonghu"></span><input type="text" placeholder="请输入用户名" name="userName">
                </div>
            </li>
            <li>
                <div class="password">
                    <span class="mima"></span><input type="password" placeholder="请输入密码" name="password">
                </div>
            </li>
            <li class="remember">
                <input type="checkbox">记住我
            </li>
            <li>
                <a href="">忘记我</a>
            </li>
            <li>
                <input type="submit" value="登陆">
            </li>
        </ul>
    </form>
    <div class="footer">
        <p>iyaq Personal Blog  <a href="">Copyright ©2012 Wang Yuyan</a></p>
        <p><a href="">iiyaq Home</a> | <a href="">Bolg
        </a> | <a href="">Work</a> | <a href="">Terms of Use</a> | <a href="">Contact Me</a></p>
    </div>
</div>
</body>
</html>
