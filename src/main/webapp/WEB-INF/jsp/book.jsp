<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
th, td {
  padding: 5px;
}
.button {
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
<title>Book event</title>
</head>
<jsp:include page="menu3.jsp" />
<center>
<body>
	<h3 style="color: red;">Book Seats</h3>

	<div id="book">
		<form:form action="/book/${boo.getUserEmail()}/${boo.getEventId()}" method="post"
			modelAttribute="boo">
			<table>
			
			<tr><td><label>Enter no. seats to book: </label></td>
				<td><form:input path="noSeats"/>
				</td></tr>
				
			</table>
			<br><br>
			<input type="SUBMIT" class="button" value="SUBMIT"/>
		</form:form>
	</div>
</body>
</center>
</html>