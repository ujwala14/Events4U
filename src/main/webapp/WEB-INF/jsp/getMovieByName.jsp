<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Movie</title>
<style>
th, td {
  padding: 5px;
}
table {
  border-spacing: 0px;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
</style>
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	
	<h3 style="color: red;">Show Movie</h3>
	<table id="t01">
			<tr> <td>Name</td> <td>:</td> <td>${movie.getMovieName()}</td></tr>
			<tr> <td>Language</td>  <td>:</td> <td>${movie.getLang()}</td> </tr>
			<tr> <td>Year</td> <td>:</td> <td>${movie.getYear()}</td></tr>
			<tr> <td>Type</td> <td>:</td> <td>${movie.getType()}</td> </tr>
			<tr> <td>Format</td> <td>:</td> <td>${movie.getFormat()}</td></tr>
			<tr> <td>Genre</td> <td>:</td> <td>${movie.getGenre()}</td></tr>
			<tr> <td>Runtime</td> <td>:</td> <td>${movie.getRuntime()}</td></tr>
			<tr> <td>Rating</td> <td>:</td> <td>${movie.getRating()}</td> </tr>
			<tr> <td>Cast</td> <td>:</td> 
				 <td><a href="/getCast/${movie.getMovieId()}">See Cast</a></td></tr>
			<tr> <td>Director(s)</td> <td>:</td> 
				 <td><a href="/getDirect/${movie.getMovieId()}">See Director(s)</a></td></tr>
		
	</table>
	
</body>
</center>
</html>