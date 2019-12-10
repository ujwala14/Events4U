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
<title>Add Actor</title>
</head>
<jsp:include page="menu2.jsp" />
<body>
<center>
	<h3 style="color: red;">Add New Actor</h3>

	<div id="addActor">
		<form:form action="/addNewActor" method="post"
			modelAttribute="act">
			<table>
			<tr><td><label>Enter Actor Id </label></td>
				<td><form:input path="actorID" /></td></tr>
			
			<tr><td>	<label>Enter Name </label></td>
				<td><form:input path="actorName" /></td></tr>
				
			<tr><td>	<label>Enter Date of Birth </label></td>
				<td><form:input path="dob" /></td></tr>
				
			<tr><td>	<label>Enter Nationality </label></td>
				<td><form:input path="actorNationality" /></td></tr>

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
</center>
</body>
</html>