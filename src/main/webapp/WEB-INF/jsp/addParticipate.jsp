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
<title>Add Participant</title>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	<h3 style="color: red;">Add New Event</h3>

	<div id="addParticipate">
		<form:form action="/addNewParticipate" method="post"
			modelAttribute="par">
			<table>
			<tr><td><label>Enter Participant Id</label></td>
				<td><form:input path="evenID" /></td></tr>
			
			<tr><td>	<label>Enter Name</label></td>
				<td><form:input path="performID" /></td></tr>

			<tr><td>	<label>Enter Performance Start time </label></td>
				<td><form:input path="start" value="00:00:00"/>
				</td></tr>

			<tr><td>	<label>Enter Performance End time </label></td>
				<td><form:input path="end" value="00:00:00"/>
				</td></tr>
				
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</body>
</center>
</html>