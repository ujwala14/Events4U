<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Cast</title>
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
	
	<h3 style="color: red;">Show Cast</h3>
	<table id ="t01" style = 'width:40%'>
		<tr><th>Actor Name</th> <th>Role</th></tr>
		<c:forEach var="listValue" items="${casts}">
			<tr>  
			<td>${listValue.getActID()}</td>
			<td>${listValue.getRole()}</td> </tr>
		</c:forEach>
	</table>
	
</body>
</center>
</html>