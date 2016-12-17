<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="/static/css/custom.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>



</head>
<body class="web-font">
    <nav class="navbar navbar-inverse navbar-custom" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="http://v3.bootcss.com/examples/theme/#">Bootstrap theme</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="http://v3.bootcss.com/examples/theme/#">Home</a></li>
                    <li><a href="http://v3.bootcss.com/examples/theme/#about">About</a></li>
                    <li><a href="http://v3.bootcss.com/examples/theme/#contact">Contact</a></li>
                    <li class="dropdown">
                        <a href="http://v3.bootcss.com/examples/theme/#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="http://v3.bootcss.com/examples/theme/#">Action</a></li>
                            <li><a href="http://v3.bootcss.com/examples/theme/#">Another action</a></li>
                            <li><a href="http://v3.bootcss.com/examples/theme/#">Something else here</a></li>
                            <li class="divider"></li>
                            <li class="dropdown-header">Nav header</li>
                            <li><a href="http://v3.bootcss.com/examples/theme/#">Separated link</a></li>
                            <li><a href="http://v3.bootcss.com/examples/theme/#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <img src="/static/image/logo1.png" class="logo">
            </div>
            <div class="col-md-10">
                <input class="search-input" placeholder="搜点什么吧" />
            </div>
            <div class="col-md-2">
                <input type="button" class="search-button web-font" value="搜索"/>
            </div>
        </div>
    </div>

</body>
</html>