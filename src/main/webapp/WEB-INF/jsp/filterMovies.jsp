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
	<h3 style="color: red;">Filter Movies</h3>

	<div id="filterMovies">
		<form:form action="/filterMovies" method="post" modelAttribute="fil">
			<table>
				<tr><td>	<label>Filter by </label></td>
				<td><form:select path="key">
						<form:option value="movieName" label="Movie Name"/>
						<form:option value="lang" label="Language" />
						<form:option value="year" label="Year"/>
						<form:option value="type" label="Type"/>
						<form:option value="format" label="Format"/>
						<form:option value="genre" label="Genre"/>
						<form:option value="rating" label="Rating"/>
						<form:option value="actorName" label="Actor's Name"/>
						<form:option value="directorName" label="Director's Name"/>
					</form:select></td></tr>
					
				<tr><td>	<label>Enter Value </label></td>
				<td><form:input path="value" /></td></tr>
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</body>
</center>
</html>