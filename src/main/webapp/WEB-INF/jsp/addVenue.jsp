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
<title>Add Venue</title>
</head>
<jsp:include page="menu2.jsp" />
<body>
<center>
	<h3 style="color: red;">Add New Venue</h3>

	<div id="addVenue">
		<form:form action="/addNewVenue" method="post"
			modelAttribute="ven">
			<table>
			<tr><td><label>Enter Venue Id </label></td>
				<td><form:input path="venueId" /></td></tr>
			
			<tr><td>	<label>Enter Venue Name </label></td>
				<td><form:input path="venueName" /></td></tr>
				
			<tr><td>	<label>Enter Venue Address </label></td>
				<td><form:input path="address" /></td></tr>
				
			<tr><td>	<label>Enter Max capacity </label></td>
				<td><form:input path="maxCapacity" /></td></tr>

			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</center>
</body>
</html>