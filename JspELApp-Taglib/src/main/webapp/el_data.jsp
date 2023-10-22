<%@ page isELIgnored="false" %>

<%
	pageContext.setAttribute("attr4", "val4",pageContext.PAGE_SCOPE);
%>

<br><b> attr1(request scope) data:: ${requestScope.attr1}</b>
<br><b> attr2(session scope) data:: ${sessionScope.attr2 }</b>
<br><b> attr3(application scope) data:: ${applicationScope.attr3}</b>
<br><b> attr1(page scope) data:: ${pageScope.attr4}</b>

<br><br>
	attr3 data :: ${attr3}