<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">

			<h2>CRM : Customer Relationship Manager</h2>

		</div>
		<div id="container">
			<form:form action="saveCustomer" modelAttribute="customer"
				method="post">
				<form:hidden path="id"/>
				<table>
					<tr>
						<td>First Name</td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td>Last Name</td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td>Email</td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</table>
			</form:form>
			<div style=""></div>
			<p>
				<a href="${pageContext.request.contextPath}/customers/list">Back
					to List</a>
			</p>
		</div>
	</div>
</body>
</html>