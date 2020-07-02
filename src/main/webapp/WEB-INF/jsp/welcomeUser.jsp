<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<jsp:include page="menu3.jsp" />

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
  background-image: url("https://www.scarletevents.com/media/images/blog-cover/big/1514653619_1_6761bd59acb918c34835da9c6ff46217_3.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  
}
</style>
<title>Welcome</title>

</head>
<body>
	<br><br>
 	<c:set var="email" value="${u.getEmail()}" scope="session" />
	<center><h1 style="color: white;">Hello ${u.getUserName()} !!</h1></center>
	<center><h1 style="color: white;">Let's find something for you!!</h1></center>
</body>
</html>