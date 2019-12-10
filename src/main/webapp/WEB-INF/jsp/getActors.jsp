<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Actors</title>

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
	
	<h3 style="color: red;">Show All Actors</h3>
	<table id ="t01" style = 'width:80%'>
		<tr> <th>Name</th> <th>DoB</th> <th>Nationality</th>
		<th>Gender</th> <th>WikiLink</th> </tr>
		<c:forEach var="listValue" items="${actors}">
			<tr><td>${listValue.getActorName()}</td>
			<td>${listValue.getDob()}</td> <td>${listValue.getActorNationality()}</td>
			<td>${listValue.getGender()}</td>
			 <td><a href="${listValue.getWikiLink()}">${listValue.getWikiLink()}</a></td></tr>
		</c:forEach>
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>