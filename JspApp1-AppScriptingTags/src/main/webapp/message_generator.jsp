
<%@page import="java.time.LocalDateTime"%>
<%! public String generateWishMessage(String user) {
	
			java.time.LocalDateTime ldt=java.time.LocalDateTime.now();
			
			int hour=ldt.getHour();
			if(hour<12) {
				return "Good Morning:: "+user;
			}
			else if(hour<16) {
				return "Good Afternoon:: "+user;
			}
			else if(hour<20) {
				return "Good Evening:: "+user;
			}
			else {
				return "Good Night:: "+user;
			}

	} %>
	
	<h1 style="color:red;text-align:center">welcome java server pages</h1>
	<br><b>Date and time :: <%=new java.util.Date() %> </b>
	
	<br>
	<% String user	="Pratik"; %>
	
	<br><bR>
	<b><i>Wish message is :: <%=generateWishMessage(user) %></i></b>