<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
th, td {
  padding: 5px;
}
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<title>Login</title>
</head>
<jsp:include page="menu1.jsp" />
<body>
<center>
	<h3 style="color: red;">Login</h3>

	<div id="login">
		<form:form action="/login" method="post"
			modelAttribute="u">
			<table>
			<tr><td>	<label>Enter Email ID</label></td>
				<td><form:input path="email" /></td></tr>
		
			<tr><td>	<label>Enter Password </label></td>
				<td><form:input path="pwd" type="password"/></td></tr>
			
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</center>
</body>
</html>