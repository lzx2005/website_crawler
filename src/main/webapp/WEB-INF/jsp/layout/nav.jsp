<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html lang="en">
<nav class="navbar navbar-inverse navbar-custom" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">随便起个名字吧</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="http://v3.bootcss.com/examples/theme/#">首页</a></li>
                <li><a href="http://v3.bootcss.com/examples/theme/#about">爬虫</a></li>
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