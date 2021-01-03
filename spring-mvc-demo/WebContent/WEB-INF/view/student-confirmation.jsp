<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
	Registration Confirmed: ${student.firstName} ${student.lastName}
	<br><br>
	Country: ${student.country}
	<br><br>
	Favorite Language: ${student.favoriteLanguage}
	<br><br>
	<ul>
	    <c:forEach var="temp" items="${student.operatingSystems }">
	        <li> ${ temp } </li>
	    </c:forEach>
	</ul>
</body>
</html>