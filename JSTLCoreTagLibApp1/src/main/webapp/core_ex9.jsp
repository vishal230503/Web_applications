<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br><b> from core_ex8.jsp </b>

<!-- define a url -->
<c:url var="googleUrl" value="http://www.google.com/search?q=${param.ss}" scope="request"/>

<c:redirect url="${googleUrl}"/>
