<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:catch var="e">
	<jsp:scriptlet>
		int a=Integer.parseInt("10");
		out.println(a);
	</jsp:scriptlet>>
</c:catch>

<br>

	exception is :: ${e}