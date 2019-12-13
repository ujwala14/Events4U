<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%String em = (String)session.getAttribute("email");%>
<h4><pre class="tab">AVAILABLE SEATS : ${avail.getAvailSeats()} </pre></h4>
