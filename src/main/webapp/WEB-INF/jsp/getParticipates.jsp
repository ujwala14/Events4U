<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Participants</title>
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
	
	<h3 style="color: red;">Show All Participants</h3>
	<table id ="t01" style = 'width:80%'>
		<tr><th>Event ID</th> <th>Performer ID</th> <th>Performance StartTime</th> <th>Performance EndTime</th>
		<c:forEach var="listValue" items="${participates}">
			<tr> <td>${listValue. getEvenID()}</td>
			<td>${listValue. getPerformID()}</td> 
			<td>${listValue.getStart().toString()}</td>
			<td>${listValue.getEnd().toString()}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>