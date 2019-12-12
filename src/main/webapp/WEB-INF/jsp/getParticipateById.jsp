<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>

	<pre class="tab">PERFORMERS/PARTICIPANTS: </pre>
	
		<c:forEach var="listValue" items="${part}">
			<pre>${listValue.getPerformID()}, ${listValue.getStart().toString()} to ${listValue.getEnd().toString()}</pre> 
		</c:forEach>

	
