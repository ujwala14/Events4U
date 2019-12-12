<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>

	<pre class="tab">Equipments required: </pre>
	
		<c:forEach var="listValue" items="${reqs}">
			<pre>${listValue.getEquipID()} - ${listValue.getQuantity_req()}</pre> 
		</c:forEach>

	
