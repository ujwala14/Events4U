<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Directors</title>
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
	
	<h3 style="color: red;">Show Director(s)</h3>
	<table id ="t01" style = 'width:40%'>
		<tr><th>Director Name</th></tr>
		<c:forEach var="listValue" items="${directs}">
			<tr>  
			<td>${listValue.getDirectID()}</td></tr>
		</c:forEach>
	</table>
	
</body>
</center>
</html>