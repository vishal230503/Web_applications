<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="fr_CA"/>

<jsp:useBean id="dt" class="java.util.Date"/>
<fmt:formateDate var="fdt" value="${dt}" type="both" dateStyle="full" timeStyle="full"/>

<br><b> The formatted date is :: ${fdt} </b>
<hr>

<fmt:formatNumber value="5435346547774" var="fnumber" type="number"/>
<br><b> The formatted date is :: ${fnumber}</b>

<hr>

<fmt:formatNumber value="543534654534543" var="fcurrency" type="currency"/>
<br><b> The formatted currency is :: ${fcurrency}</b>

<br>
<hr>

<fmt:setBundle basename="com/nt/commons/myfile"/>

<fmt:message key="wish.msg" var="fmsg"/>
<br> The formatted message is :: ${fmsg}