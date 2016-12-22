<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <jsp:include page="../layout/css.jsp"/>
    <jsp:include page="../layout/script.jsp"/>
</head>
<body class="web-font">
    <jsp:include page="../layout/nav.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <img src="../../../static/image/logo1.png" class="logo">
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