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
<title>Add Director</title>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	<h3 style="color: red;">Add New Director</h3>

	<div id="addDirector">
		<form:form action="/addNewDirector" method="post"
			modelAttribute="dir">
			<table>
			<tr><td><label>Enter Director Id</label></td>
				<td><form:input path="directorID" /></td></tr>
			
			<tr><td>	<label>Enter Name</label></td>
				<td><form:input path="directorName" /></td></tr>
				
			<tr><td>	<label>Enter Date of Birth</label></td>
					<td><form:input path="dob" /></td></tr>
				
			<tr><td>	<label>Enter Nationality </label></td>
				<td><form:input path="directorNationality" /></td></tr>

			<tr><td>	<label>Enter Gender </label></td>
				<td><form:select path="gender">
						<form:option value="Male" label="Male"/>
						<form:option value="Female" label="Female"/>
						<form:option value="Other" label="Other"/>
					</form:select></td></tr>
			
			<tr><td>	<label>Enter WikiLink </label></td>
				<td><form:input path="wikiLink" /></td></tr>
					
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</body>
</center>
</html>