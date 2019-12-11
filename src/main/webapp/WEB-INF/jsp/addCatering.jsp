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
<title>Add Caterer</title>
</head>
<jsp:include page="menu2.jsp" />
<body>
<center>
	<h3 style="color: red;">Add New Venue</h3>

	<div id="addCatering">
		<form:form action="/addNewCatering" method="post"
			modelAttribute="cat">
			<table>
			<tr><td><label>Enter Caterer Id </label></td>
				<td><form:input path="catID" /></td></tr>
			
			<tr><td>	<label>Enter Caterer Name </label></td>
				<td><form:input path="catName" /></td></tr>
				
			<tr><td>	<label>Enter Caterer's Contact No. </label></td>
				<td><form:input path="catContNo" /></td></tr>
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</center>
</body>
</html>