<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
 background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS72KTs0xzDdX5AiNrUDI7cDOkqFExIYVyx-GCbt58IR3Ax5YTq');
  background-repeat: no-repeat;
  background-size: cover;
  
}

.navbar {
  overflow: hidden;
  background-color: #333; 
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.subnav {
  float: left;
  overflow: hidden;
}

.subnav .subnavbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .subnav:hover .subnavbtn,.dropdown:hover .dropbtn {
  background-color: red;
}

.subnav-content {
  display: none;
  position: absolute;
  left: 0;
  background-color: red;
  width: 100%;
  z-index: 1;
}

.subnav-content a {
  float: left;
  color: white;
  text-decoration: none;
}

.subnav-content a:hover {
  background-color: #eee;
  color: black;
}

.subnav:hover .subnav-content {
  display: block;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
 }
 .dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
} 
</style>

<div class="navbar">
	<%String em = (String)session.getAttribute("email");%>
    <a href="/welcomeUser/<%=em%>">EVENTS4U</a>
  <div class="subnav">
    <button class="subnavbtn">Events <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="/user/<%=em%>/getUserEvents">Show</a>
      <a href="/user/<%=em%>/getUserFilter">Filter</a>
    </div>
  </div> 
  
  
    <a href="/user/<%=em%>/booked">Booked Events</a>
  	<a href="/user/<%=em%>/attended">Attended Events</a>
  
    <a href="/">Logout</a>
</div>