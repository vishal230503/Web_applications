<%@ page isELIgnored="false"%>

<b> uname request param value :: ${param.uname }</b><br>

<b> sadd request param values :: ${paramValues.sadd[0]},${paramValues.sadd[1]}</b>

<br><br>
<b> user-agent request header value :: ${header['user-agent']}</b><br>
<b> accept request header values :: ${headerValues.accept[0]},${headerValues.accept[1]}</b>

<br><br>

	Session Id's cookie name :: ${cookie.JSESSIONID.name} <br>
	Session Id's cookie value :: ${cookie.JSESSIONID.value} <br>
	
<br><br>

	c1 --->context param value :: ${initParam.c1} <br>
	c2 --->context param value :: ${initParam.c2} <br>
