
<%@ page import ="com.nt.beans.*" %>

<!-- create or locates java bean class object -->
<jsp:useBean id="st" class="com.nt.beans.StudentDetails" scope="session"/>

<p> <b>
<!-- set values to bean properties -->
sno :: <jsp:getProperty property="sno" name="st"/><br>
sname :: <jsp:getProperty property="sname" name="st"/><br>
sadd :: <jsp:getProperty property="sadd" name="st"/><br>
avg :: <jsp:getProperty property="avg" name="st"/><br>
</b>
</p>
<br>
<b> Java bean class object's data is retrieved and displayed</b>

