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
<title>Add Movie</title>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	<h3 style="color: red;">Add New Event</h3>

	<div id="addEvent">
		<form:form action="/addNewEvent" method="post"
			modelAttribute="eve">
			<table>
			<tr><td><label>Enter Event Id</label></td>
				<td><form:input path="eventId" /></td></tr>
			
			<tr><td>	<label>Enter Name</label></td>
				<td><form:input path="eventName" /></td></tr>
				
			<tr><td>	<label>Enter Type</label></td>
				<td><form:select path="eventType">
						<form:option value="Concert" label="Concert"/>
						<form:option value="Conference" label="Conference" />
						<form:option value="Dance" label="Dance"/>
						<form:option value="Indoor Game" label="Indoor Game"/>
						<form:option value="Outdoor Game" label="Outdoor Game"/>
						<form:option value="Plays" label="Plays"/>
						<form:option value="Talks" label="Talks"/>
					</form:select></td></tr>
				
			<tr><td>	<label>Enter Date</label></td>
				<td><form:input path="date" type="date"/></td></tr>

			<tr><td>	<label>Enter Start time </label></td>
				<td><form:input path="startTime" value="00:00:00"/>
				</td></tr>

			<tr><td>	<label>Enter End time </label></td>
				<td><form:input path="endTime" value="00:00:00"/>
				</td></tr>
			
			<tr><td>	<label>Enter Description </label></td>
				<td><form:input path="description" /></td></tr>	
					
			<tr><td><label>Select Venue </label></td>
				<td><form:select path="venId">
						<form:options items="${venueNames}" />
					</form:select>
				</td></tr>
			
			<tr><td>	<label>Enter Catering </label></td>
				<td><form:input path="caterId" />
				</td></tr>		
					
			<tr><td>	<label>Enter Photograher </label></td>
				<td><form:input path="photoId" />
				</td></tr>
				
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</body>
</center>
</html>