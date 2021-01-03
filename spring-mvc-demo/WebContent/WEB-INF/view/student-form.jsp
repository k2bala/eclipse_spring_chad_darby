<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">

First Name : <form:input path="firstName" />
		<br>
		<br>
Last Name: <form:input path="lastName" />
		<br>
		<br>
		<form:select path="country">
			<form:options items="${theCountryOptions}" />
		</form:select>
		<br>
		<br>
		Favorite Language:
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		Python <form:radiobutton path="favoriteLanguage" value="Python" />
		<br>
		<br>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac   <form:checkbox path="operatingSystems" value="Mac"/>
		<input type="submit" value="Register">

	</form:form>
</body>
</html>