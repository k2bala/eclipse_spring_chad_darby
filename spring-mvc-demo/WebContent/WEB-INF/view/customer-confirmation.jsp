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
	Registration Confirmed: ${customer.firstName} ${customer.lastName}
	<br><br>
	Free Passes: ${customer.freePasses}
	<br><br>
	Course Code: ${customer.courseCode}
	<br><br>
	Zip Code: ${customer.zipCode}
	<br><br>
</body>
</html>