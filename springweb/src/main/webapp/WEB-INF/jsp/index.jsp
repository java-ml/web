<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2020/7/17
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:out value="${pageContext.request.contextPath}" escapeXml="false" default="默认值"></c:out>
</head>
<body>
<h1>${user}</h1>
</body>
</html>
