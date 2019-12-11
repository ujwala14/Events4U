<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Events</title>
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
	
	<h3 style="color: red;">Show All Events</h3>
	<table id ="t01" style = 'width:80%'>
		<tr><th>Name</th> <th>Type</th> <th>Date</th>
		<th>StartTime</th> <th>EndTime</th> <th>Desc</th> <th>Venue</th> 
		<th>Catering</th><th>Photography</th></tr>
		<c:forEach var="listValue" items="${events}">
			<tr> <td>${listValue.getEventName()}</td>
			<td>${listValue.getEventType()}</td> <td>${listValue.getDate()}</td>
			<td>${listValue.getStartTime().toString()}</td>
			<td>${listValue.getEndTime().toString()}</td>
			<td>${listValue.getDescription()}</td> <td>${listValue.getVenId()}</td>
			<td>${listValue.getCaterId()}</td><td>${listValue.getPhotoId()}</td> 
	<!-- 		<td>
					<a href="/getCast/${listValue.getEventId()}">See Cast</a>		
			</td>
			<td>
					<a href="/getDirect/${listValue.getEventId()}">See Director(s)</a>	
			</td>
		-->	
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>