<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="msg" value="hello" scope="request"/>

msg	variable value is :: <c:out value="${msg}"/><br>
	msg variable value :: ${msg} <br>
	
	<c:remove var="msg" scope="request"/>
	
	<br>
	
	msg variable value is :: <c:out value="${msg}"/><br>
		msg variable value :: ${msg} <br> 