

<b> from a.jsp(creating pageContext attributes) </b>
<!-- create PageContext attributes -->

<%
	pageContext.setAttribute("attr1","val1",pageContext.PAGE_SCOPE);
	pageContext.setAttribute("attr2","val2",pageContext.REQUEST_SCOPE);
	pageContext.setAttribute("attr3","val3",pageContext.SESSION_SCOPE);
	pageContext.setAttribute("attr4","val4",pageContext.APPLICATION_SCOPE);
%>

<jsp:forward page="b.jsp">
