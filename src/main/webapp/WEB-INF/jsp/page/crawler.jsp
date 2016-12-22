<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html lang="en">
<head>
    <meta charset="UTF-8">
    <title>爬取需要的网站</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <jsp:include page="../layout/css.jsp"/>
    <jsp:include page="../layout/script.jsp"/>
</head>
<body class="web-font">
    <jsp:include page="../layout/nav.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <img src="../../../static/image/logo3.png" class="logo">
            </div>
            <div class="col-md-10">
                <div class="input-group">
                    <span class="input-group-addon">http://</span>
                    <input type="text" class="form-control search-input" placeholder="需要爬取的网站首页">
                </div>
            </div>
            <div class="col-md-2">
                <input type="button" class="search-button web-font" value="开始爬取"/>
            </div>
        </div>
    </div>
</body>
</html>