<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:out value="${pageContext.request.contextPath}" escapeXml="false" default="默认值"></c:out>

    <form action="/add" method="post" >
       name:<br>
        <input type="text" name="username" value="Mickey">
        <br>
        <br>
        <input type="submit" value="Submit">
    </form>
</head>
<body>
</body>
</html>