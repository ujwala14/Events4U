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
	
	<h3 style="color: red;">Event - ${event.getEventName()}</h3>
	<table id ="t01" style = 'width:50%'>

	<tr><td><jsp:include page="/getCatering/${event.getCaterId()}" /></td></tr>
	<tr><td><jsp:include page="/getPhotography/${event.getPhotoId()}" /></td></tr>
	<tr><td><jsp:include page="/getRequired/${event.getEventId()}" /></td></tr>
		
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>