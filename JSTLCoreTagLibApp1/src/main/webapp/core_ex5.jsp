<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1> printing all the request param names and values </h1>

<c:forEach var="p" items="${paramValues}">
	name :: ${	p.key} <br>
	values :: 
	<c:forEach var="pv" items="${p.value}">
		${pv}
	
	</c:forEach>
	
	<br>
</c:forEach>