<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%String em = (String)session.getAttribute("email");%>
<h4><pre class="tab">AVAILABLE SEATS : ${avail.getAvailSeats()} </pre></h4>
<c:set var = "seats" scope = "session" value = "${avail.getAvailSeats()}"/>
<c:if test = "${seats > 0}">
<a href="/book/<%=em%>/${avail.getEventId()}" class="button2">Book</a> 
</c:if>
<c:if test = "${seats <= 0}">
<h3 style="color: red;">SOLD OUT!!!<center></center></h3>
</c:if>