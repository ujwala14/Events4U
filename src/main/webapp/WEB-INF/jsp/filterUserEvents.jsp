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
<title>Filter</title>
</head>
<jsp:include page="menu3.jsp" />
<center>
<body>
	<h3 style="color: red;">Filtering</h3>

	<div id="filterUserEvents">
		<form:form action="/user/${uid.getEmail()}/getUserFilter" method="post"
			modelAttribute="fil">
			<table>
			
			<tr><td><label>Select Category</label></td>
			<td><form:select path="value">
						<form:option value="Concert" label="Concert"/>
						<form:option value="Conference" label="Conference" />
						<form:option value="Dance" label="Dance"/>
						<form:option value="StandUp Comedy" label="StandUp Comedy"/>
						<form:option value="Indoor Game" label="Indoor Game"/>
						<form:option value="Outdoor Game" label="Outdoor Game"/>
						<form:option value="Plays" label="Plays"/>
						<form:option value="Talks" label="Talks"/>
					</form:select></td></tr>
				
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="SUBMIT"/>
		</form:form>
	</div>
</body>
</center>
</html>