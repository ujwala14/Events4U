<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Performers</title>
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
	
	<h3 style="color: red;">Show All Performers</h3>
	<table id ="t01" style = 'width:80%'>
		<tr><th>Name</th> <th>Category</th> <th>Phone No.</th>
		<th>SocialMedia</th> <th>Email ID</th></tr>
		<c:forEach var="listValue" items="${performers}">
			<tr> <td>${listValue.getPerformerName()}</td>
			<td>${listValue.getCategory()}</td> <td>${listValue.getPhoneNo()}</td>
			<td>${listValue.getSocialMedia()}</td>
			<td>${listValue.getEmail()}</td> 
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br>
</body>
</center>
</html>