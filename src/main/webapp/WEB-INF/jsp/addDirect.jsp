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
<title>Add Director</title>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	<h3 style="color: red;">Add Director(s) of the movie</h3>

	<div id="addDirect">
		<form:form action="/addDirect/${direct.getMovID()}" method="post"
			modelAttribute="direct">
			<table>
			<tr><td><label>Movie Id</label></td>
				<td><label>${direct.getMovID()}</label></tr>
				
			<tr><td><label>Select Director </label></td>
				<td><form:select path="directID">
						<form:options items="${directorNames}" />
					</form:select></td></tr>
				
			</table>
			<br><br>
			<input type="SUBMIT" name="add" class="button" value="Add More"/>
			<input type="SUBMIT" name="fin" class="button" value="Done"/>
		</form:form>
	</div>
</body>
</center>
</html>