<%@ page language="java" isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<b> traditional for loop </b>
<table border="1" align="center">
	<c:forEach var="i" begin="1" end="10" step="1">
		<tr>
			<td>2*${i}</td>
			<td> ${2*i}</td>
		</tr>
	</c:forEach>
</table>

<br> <b>Enhanced for loop</b>
<%
	String names[]=new String[]{"raja","rani","suresh","ramesh"};
		request.setAttribute("namesInfo", names); 
	%>

<c:forEach var="nam" items="${nameInfo}">
	${nam};
</c:forEach>

<br>

<br><b> Enhanced for loop </b>
<jsp:scriptlet>
<![CDATA[
         List<Long> phones=new ArrayList<Long>();
         phones.add(54353453L);phones.add(4534345435L); phones.add(5345435345L);
         session.setAttribute("phonesInfo",phones);
         ]]>
 </jsp:scriptlet>
 
  <c:forEach  var="ph"  items="${phonesInfo}">
             ${ph}<br>
  </c:forEach>

