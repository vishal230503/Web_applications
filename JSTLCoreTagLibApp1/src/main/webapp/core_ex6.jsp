<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1> printing all the request param names and values </h1>

<c:forEach var="h" items="${headerValues}">
	name :: ${h.key} <br>
	values :: 
	<c:forEach var="hv" items="${h.value}">
		${hv};
	</c:forEach>
	<br>
</c:forEach>