<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="msg" value="hello,how are u?"/>

	length is :: ${fn:length(msg)} <br>
	uppercase :: ${fn:toUpperCase(msg)} <br>
	lowercase :: ${fn:toLowerCase(msg)} <br>
	subString :: ${substring(msg,0,6)) <br>
	starts With "hello" :: ${fn:startsWith(msg,"hello")} <br>
	ends With "?" :: ${fn:endsWith(msg,"?")}<br>