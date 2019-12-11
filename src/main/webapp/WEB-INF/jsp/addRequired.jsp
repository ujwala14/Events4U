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
<title>Add Required</title>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	<h3 style="color: red;">Add New Equipment For Event</h3>

	<div id="addRequired">
		<form:form action="/addNewRequired/${req.getEvenID()}" method="post"
			modelAttribute="req">
			<table>
			
			<tr><td><label>Event Id</label></td>
				<td><label>${req.getEvenID()}</label></tr>
			
			<tr><td><label>Select Equipment </label></td>
				<td><form:select path="equipID">
						<form:options items="${equipments}" />
					</form:select>
				</td></tr>

			<tr><td>	<label>Enter Quantity Required </label></td>
				<td><form:input path="quantity_req"/>
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