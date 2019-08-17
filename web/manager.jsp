<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- 引入jQuery -->
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- 引入样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <title>管理员</title>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<style type="text/css">
		body {
			background-image: url("images/u=2457305625,2231421459&fm=26&gp=0.jpg");
		}
	</style>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<!-- 汉堡按钮，下面的 span是汉堡按钮的杠数-->
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">人员管理</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					   aria-expanded="false">hai~<span class="glyphicon glyphicon-user"> </span>${sessionScope.user.userName}</a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">退出</a>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					   aria-expanded="false">员工管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addServlet.jsp" target="show">员工增加</a></li>
						<li role="separator" class="divider"></li>
						<li role="separator" class="divider"></li>
						<li><a href="LoginServlet?method=userList" target="show">员工列表</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					   aria-expanded="false">工资管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addSalary.jsp" target="show">工资增加</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="updateSalary.jsp" target="show">工资修改</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="SalaryServlet?method=findAllSalary" target="show">工资列表</a></li>
					</ul>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">招聘管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="addAppLicant.jsp" target="show">招聘信息增加</a></li>
                        <li role="separator" class="divider"></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="AppLicantServlet?method=findAll" target="show">应聘人员列表</a></li>
                    </ul>
                </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">培训管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="TrainServlet?method=findAll" target="show">培训人员列表</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="addTrain.jsp" target="show">培训人员增加</a></li>
                            <li role="separator" class="divider"></li>
                        </ul>
                    </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">请假管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="LeaveServlet?method=findAll" target="show">请假人员列表</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="addLeave.jsp" target="show">申请请假</a></li>
                        <li role="separator" class="divider"></li>
                    </ul>
                </li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Link</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					   aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
<div class="embed-responsive embed-responsive-16by9">
	<iframe class="embed-responsive-item" name="show"></iframe>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

</body>

</html>