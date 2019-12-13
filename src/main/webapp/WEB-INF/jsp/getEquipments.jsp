<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Equipments</title>

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
	
	<h3 style="color: red;">Show All Equipments</h3>
	<table id ="t01" style = 'width:20%'>
		<tr> <th>Equipment Name</th>
		<c:forEach var="listValue" items="${equipments}">
			<tr><td>${listValue.getEquipName()}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>