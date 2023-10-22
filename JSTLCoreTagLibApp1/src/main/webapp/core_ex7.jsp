<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- define a variable -->
<c:set var="msg" value="hello,how are u ?" scope="request"/>

<c:forTokens items="${msg}" var="tkn" delims=" ">
	${tkn} <br>
</c:forTokens>

