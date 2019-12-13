<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Booked Events</title>
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
.button2 {
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
</head>
<jsp:include page="menu3.jsp" />


<center>
<body>
	<%String em = (String)session.getAttribute("email");%>
	<h3 style="color: red;">Show All Booked Events</h3>
	
	<table id ="t01" style = 'width:50%'>

		<c:forEach var="listValue" items="${events}">
			<tr><td>
			<h3> ${listValue.getEventName()}</h3>
			<pre class="tab">${listValue.getDate()}	${listValue.getStartTime().toString()} to ${listValue.getEndTime().toString()}</pre>
			<pre>${listValue.getEventType()} - ${listValue.getDescription()}</pre>
			<jsp:include page="/getVenue/${listValue.getVenId()}" />
			<jsp:include page="/getParticipate/${listValue.getEventId()}" />
			<pre>No. of seats booked : ${listValue.getCaterId()}</pre>
			
			</td>
			
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>