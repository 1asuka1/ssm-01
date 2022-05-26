<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/asserts/css/dashboard.css" rel="stylesheet">
<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>#</th>
            <th>编号</th>
            <th>姓名</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${roles}" var="role" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${role.id}</td>
                <td>${role.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>