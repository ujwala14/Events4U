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
	<h3 style="color: red;">Add New Movie</h3>

	<div id="addMovie">
		<form:form action="/addNewMovie" method="post"
			modelAttribute="mov">
			<table>
			<tr><td><label>Enter Movie Id</label></td>
				<td><form:input path="movieId" /></td></tr>
			
			<tr><td>	<label>Enter Name</label></td>
				<td><form:input path="movieName" /></td></tr>
				
			<tr><td>	<label>Enter Language</label></td>
				<td><form:select path="lang">
						<form:option value="English" label="English"/>
						<form:option value="Hindi" label="Hindi" />
						<form:option value="Tamil" label="Tamil"/>
						<form:option value="Kannada" label="Kannada"/>
						<form:option value="Telugu" label="Telugu"/>
					</form:select></td></tr>
				
			<tr><td>	<label>Enter Year of Release </label></td>
				<td><form:input path="year" /></td></tr>

			<tr><td>	<label>Enter Type </label></td>
				<td><form:select path="type">
						<form:option value="Art" label="Art"/>
						<form:option value="Commercial" label="Commercial"/>
					</form:select></td></tr>

			<tr><td>	<label>Enter Format </label></td>
				<td><form:select path="format">
						<form:option value="2D" label="2D"/>
						<form:option value="3D" label="3D"/>
						<form:option value="IMAX" label="IMAX"/>
					</form:select></td></tr>
					
			<tr><td>	<label>Enter Genre </label></td>
				<td><form:select path="genre">
						<form:option value="Action" label="Action"/>
						<form:option value="Adventure" label="Adventure"/>
						<form:option value="Animation" label="Animation"/>
						<form:option value="Comedy" label="Comedy"/>
						<form:option value="Drama" label="Drama"/>
						<form:option value="Fantasy" label="Fantasy"/>
						<form:option value="Horror" label="Horror"/>
						<form:option value="Sci-Fi" label="Sci-Fi"/>
						<form:option value="Thriller" label="Thriller"/>
					</form:select></td></tr>
					
			<tr><td>	<label>Enter Runtime(mins)  </label></td>
				<td><form:input path="runtime" /></td></tr>
			
			<tr><td>	<label>Enter Rating </label></td>
				<td><form:input path="rating" /></td></tr>
					
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="Submit"/>
		</form:form>
	</div>
</body>
</center>
</html>