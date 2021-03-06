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
.button {
  background-color: #e01d5b;
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
</head>
<jsp:include page="menu2.jsp" />
<center>
<body>
	
	<h3 style="color: red;">Show All Events</h3>
	<a href="/getEvents" class="button">New</a> 
	<a href="/getOldEvents" class="button">Old</a>
	<br><br>
	
	<table id ="t01" style = 'width:50%'>

		<c:forEach var="listValue" items="${events}">
			<tr><td>
			<h3> ${listValue.getEventName()}</h3>
			<pre class="tab">${listValue.getDate()}	${listValue.getStartTime().toString()} to ${listValue.getEndTime().toString()}</pre>
			<pre>${listValue.getEventType()} - ${listValue.getDescription()}</pre>
			<jsp:include page="/getVenue/${listValue.getVenId()}" />
			<jsp:include page="/getParticipate/${listValue.getEventId()}" />
			<jsp:include page="/getAvailableAdmin/${listValue.getEventId()}" />
			<a href="/getEventMore/${listValue.getEventId()}">See more details</a>
			
			</td>
			
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>