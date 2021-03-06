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
	<h3 style="color: red;">Add Performers</h3>

	<div id="addParticipate">
		<form:form action="/addNewParticipate/${part.getEvenID()}" method="post"
			modelAttribute="part">
			<table>
			
			<tr><td><label>Event Id</label></td>
				<td><label>${part.getEvenID()}</label></tr>
			
			<tr><td><label>Select Performer </label></td>
				<td><form:select path="performID">
						<form:options items="${performers}" />
						<form:option value="None" label="None"/>
					</form:select>
				</td></tr>

			<tr><td>	<label>Enter Performance Start time </label></td>
				<td><form:input path="start" value="00:00:00"/>
				</td></tr>

			<tr><td>	<label>Enter Performance End time </label></td>
				<td><form:input path="end" value="00:00:00"/>
				</td></tr>
				
			</table>
			<br><br>
			<input type="SUBMIT" name="add" class="button" value="Add More"/>
			<input type="SUBMIT" name="fin" class="button" value="Done"/>
		</form:form>
	</div>
</body>
</center>
</html>