<%@ page import="com.nt.beans.*" %>

<!-- create or locates java bean class object -->
<jsp:useBean id="st" class="com.nt.beans.StudentDetails" scope="session"/>

<!-- set value to bean properties -->
<jsp:setProperty property="sno" name="st" value="1001"/>
<jsp:setProperty property="sname" name="st" value="raja"/>
<jsp:setProperty property="sadd" name="st" value="hyd"/>
<jsp:setProperty property="avg" name="st" value="89.66"/>
<br>
<h1> Values are set to bean properties </h1>