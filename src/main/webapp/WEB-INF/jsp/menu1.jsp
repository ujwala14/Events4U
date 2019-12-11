<!DOCTYPE html>

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

.navbar a:hover, .subnav:hover .subnavbtn {
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


</style>

<div class="navbar">
    <a href="/">EVENTS4U</a>
  <div class="subnav">
    <a href="/login">Login</a>
  </div> 
  <div class="subnav">
    <a href="/register">Register</a>
  </div> 
  
</div>