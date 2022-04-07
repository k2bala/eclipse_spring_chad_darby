<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Rest Demo</title>
</head>
<body>
<h3>Spring Rest Demo</h3>
<a href="${pageContext.request.contextPath}/test/hello">Rest End Point link</a>
<br>
<a href="${pageContext.request.contextPath}/api/students">All Students</a>
</body>
</html>