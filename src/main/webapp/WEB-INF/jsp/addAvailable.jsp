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
<title>Add Availability</title>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	<h3 style="color: red;">Add Seating Availabilty</h3>

	<div id="addAvailable">
		<form:form action="/addNewAvailable/${avai.getEventId()}" method="post"
			modelAttribute="avai">
			<table>
			
			<tr><td><label>Event Id</label></td>
				<td><label>${avai.getEventId()}</label></tr>
			

			<tr><td><label>Enter Max Available Seats</label></td>
				<td><form:input path="availSeats"/>
				</td></tr>
				
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="SUBMIT"/>
		</form:form>
	</div>
</body>
</center>
</html>