<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Movies</title>
<style>
table, th, td {
  border: 1px solid black;
}
th, td {
  padding: 15px;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
table#t01 th {
  background-color: black;
  color: white;
}
</style>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	
	<h3 style="color: red;">Show All Movies</h3>
	<table id ="t01" style = 'width:80%'>
		<tr><th>Name</th> <th>Language</th> <th>Year</th>
		<th>Type</th> <th>Format</th> <th>Genre</th> <th>Runtime</th> <th>Rating</th>
		<th>Cast</th> <th>Director</th></tr>
		<c:forEach var="listValue" items="${movies}">
			<tr> <td>${listValue.getMovieName()}</td>
			<td>${listValue.getLang()}</td> <td>${listValue.getYear()}</td>
			<td>${listValue.getType()}</td> <td>${listValue.getFormat()}</td>
			<td>${listValue.getGenre()}</td> <td>${listValue.getRuntime()}</td>
			<td>${listValue.getRating()}</td> 
			<td>
					<a href="/getCast/${listValue.getMovieId()}">See Cast</a>		
			</td>
			<td>
					<a href="/getDirect/${listValue.getMovieId()}">See Director(s)</a>	
			</td>
			
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>