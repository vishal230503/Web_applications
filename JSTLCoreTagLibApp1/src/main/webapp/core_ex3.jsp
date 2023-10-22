<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${param.p<0}">
		${param.p} is Negetive
	</c:when>
	<c:when test="${param.p>0}">
		${param.p} is positive
	</c:when>
	<c:otherwise>
		value is zero
	</c:otherwise>
	
</c:choose>