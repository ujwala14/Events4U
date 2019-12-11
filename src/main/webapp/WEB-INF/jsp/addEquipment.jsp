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
<title>Add Equipment</title>
</head>
<jsp:include page="menu2.jsp" />
<body>
<center>
	<h3 style="color: red;">Add New Venue</h3>

	<div id="addEquipment">
		<form:form action="/addNewEquipment" method="post"
			modelAttribute="equ">
			<table>
			<tr><td><label>Enter Equipment Id </label></td>
				<td><form:input path="equipID" /></td></tr>
			
			<tr><td>	<label>Enter Equipment Name </label></td>
				<td><form:input path="equipName" /></td></tr>
				
			<tr><td>	<label>Enter Quantity Available </label></td>
				<td><form:input path="quantity_avai" /></td></tr>
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</center>
</body>
</html>