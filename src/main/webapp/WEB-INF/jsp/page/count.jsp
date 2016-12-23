<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>数据库统计</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <jsp:include page="../layout/css.jsp"/>
    <jsp:include page="../layout/script.jsp"/>
</head>
<body class="web-font">
<jsp:include page="../layout/nav.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-12 text-center">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th class="text-center" width="50%">域名</th>
                    <th class="text-center" width="50%">数量</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${count}" var="items" varStatus="count">
                    <tr>
                        <td>${items.host }</td>
                        <td>${items.count }</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>