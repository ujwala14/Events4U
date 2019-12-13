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
<title>Add Performer</title>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	<h3 style="color: red;">Add New Performer</h3>

	<div id="addPerformer">
		<form:form action="/addNewPerformer" method="post"
			modelAttribute="per">
			<table>
			<tr><td><label>Enter Performer Id</label></td>
				<td><form:input path="performerID" /></td></tr>
			
			<tr><td>	<label>Enter Performer's Name</label></td>
				<td><form:input path="performerName" /></td></tr>
				
			<tr><td>	<label>Enter Category</label></td>
				<td><form:select path="category">
						<form:option value="Singer" label="Singer"/>
						<form:option value="Dancer" label="Dancer" />
						<form:option value="Theater group" label="Theater group"/>
						<form:option value="Actor" label="Actor"/>
						<form:option value="Sports person" label="Sports person"/>
						<form:option value="Speaker" label="Speaker"/>
						<form:option value="StandUp Comedy" label="StandUp Comedy"/>
						<form:option value="Team" label="Team"/>
					</form:select></td></tr>
				
			<tr><td>	<label>Enter Phone no.</label></td>
				<td><form:input path="phoneNo" /></td></tr>

			<tr><td>	<label>Enter Social Media Account </label></td>
				<td><form:input path="socialMedia" />
				</td></tr>

			<tr><td>	<label>Enter Email ID</label></td>
				<td><form:input path="email" />
				</td></tr>
			
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</body>
</center>
</html>