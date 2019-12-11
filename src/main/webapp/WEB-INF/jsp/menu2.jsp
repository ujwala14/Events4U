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
    <a href="/">EVENTS4U</a>
  <div class="subnav">
    <button class="subnavbtn">Events <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="/addNewEvent">Add</a>
      <a href="/getEvents">Show</a>
    </div>
  </div> 
  <div class="subnav">
    <button class="subnavbtn">Performers <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="/addNewPerformer">Add</a>
      <a href="/getPerformers">Show</a>
    </div>
  </div> 
  <div class="subnav">
    <button class="subnavbtn">Facilities <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
    
      <div class="dropdown">
    	<button class="dropbtn">Venue <i class="fa fa-caret-down"></i>
    	</button>
    	<div class="dropdown-content">
      		<a href="/AddVenue">Add</a>
      		<a href="/ShowVenue">Show</a>
    	</div>
      </div>
      
      <div class="dropdown">
    	<button class="dropbtn">Catering <i class="fa fa-caret-down"></i>
    	</button>
    	<div class="dropdown-content">
      		<a href="/AddCaterer">Add</a>
      		<a href="/ShowCaterers">Show</a>
    	</div>
      </div>
      
      <div class="dropdown">
    	<button class="dropbtn">Photography <i class="fa fa-caret-down"></i>
    	</button>
    	<div class="dropdown-content">
      		<a href="/AddPhotographer">Add</a>
      		<a href="/ShowPhotographers">Show</a>
    	</div>
      </div>
      
      <div class="dropdown">
    	<button class="dropbtn">Equipment <i class="fa fa-caret-down"></i>
    	</button>
    	<div class="dropdown-content">
      		<a href="/AddEquipment">Add</a>
      		<a href="/ShowEquipments">Show</a>
    	</div>
      </div>
      
    </div>
    </div>
</div>