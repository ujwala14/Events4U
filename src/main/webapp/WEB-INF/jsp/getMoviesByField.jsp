<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Movies</title>
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
	
	<h3 style="color: red;">List of Movies</h3>
	<table id="t01">
		
		<c:forEach var="listValue" items="${movies}">
			<tr> <td> ${listValue.getMovieName()} </td>
			<td><a href ="/getMovie/${listValue.getMovieName()}"> See more </a></td></tr>
			
		</c:forEach>
	</table>
	
</body>
</center>
</html>