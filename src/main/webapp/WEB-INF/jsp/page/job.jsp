<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>爬虫任务</title>
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
                            <th>#</th>
                            <th>域名</th>
                            <th>状态</th>
                            <th>开始时间</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${jobs}" var="items" varStatus="jobs">
                            <tr>
                                <td>${items.markId }</td>
                                <td>${items.host}</td>
                                <td>
                                        <c:choose>
                                            <c:when test="${items.status==0}">
                                                <span class="label label-info">READY</span>
                                            </c:when>
                                            <c:when test="${items.status==1}">
                                                <span class="label label-warning">RUNNING</span>
                                            </c:when>
                                            <c:when test="${items.status==2}">
                                                <span class="label label-success">FINISH</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="label label-danger">FAILED</span>
                                            </c:otherwise>
                                        </c:choose>
                                </td>
                                <td><fmt:formatDate value="${items.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>