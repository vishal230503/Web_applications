<%@page import="java.sql.*"%>

<%! 
         Connection  con=null;
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;
        
        public void jspInit(){
        	// get direct acess to ServletConfig object
        	    ServletConfig cg=getServletConfig();
        	    String  driver=cg.getInitParameter("driver");
        	    String  url=cg.getInitParameter("url");
        	    String  user=cg.getInitParameter("dbuser");
        	    String  pwd=cg.getInitParameter("dbpwd");
        	    
        	    try{
        	    	//Load jdbc driver class
        	    	Class.forName(driver);
        	    	//establish the Connection
        	    	con=DriverManager.getConnection(url,user,pwd);
        	    	//create PreparedStatement objs
        	    	ps1=con.prepareStatement("INSERT INTO JSP_STUDENT VALUES(STUD_SEQ.NEXTVAL,?,?,?)");
        	    	ps2=con.prepareStatement("SELECT * FROM JSP_STUDENT");
        	    	
        	    }
        	    catch(SQLException se){
        	    	se.printStackTrace();
        	    }
        	    catch(ClassNotFoundException cnf){
        	    	cnf.printStackTrace();
        	    }
        	    catch(Exception e){
        	    	e.printStackTrace();
        	    }
              
              
               } %>
               
               
               <%
               // read the addtional req param value
                 String  pval=request.getParameter("s1");
               
               //differentiate logics for the submit , hyperlinks
               if(pval.equalsIgnoreCase("register")){   //for submit button
            	   //read form data
            	   String name=request.getParameter("sname");
            	   String addrs=request.getParameter("sadd");
            	   float avg=Float.parseFloat(request.getParameter("avg"));
            	   //set values to query params
            	    ps1.setString(1,name);
            	   ps1.setString(2,addrs);
            	   ps1.setFloat(3,avg);
            	  //execute the SQL Query
            	  int count=ps1.executeUpdate();
            	  
            	  if(count==0){ %>
            	    <h1 style="color:red;text-align:center"> Student registration failed </h1>
            	<%   } //if
            	else {  %>
            	    <h1 style="color:red;text-align:center"> Student registration Succedded </h1>
            	 
            	 <% }//else
            	   
               }//if
               else{ //for  hyperlink
                  
            	   //execute the SQL Query
            	   ResultSet rs=ps2.executeQuery();  %>
            	  <table bgcolor="cyan"  cols="4" align="center"  border="1" >
            	    <tr>
            	          <td>SNO</td><td>SNAME</td><td>SADD</td><td>AVG</td>
            	    </tr>
            	  
            	 
            	  
            	  <%
            	    //process the ResultSet object
            	      while(rs.next()){  %>
            	       <tr>
            	          <td> <%=rs.getInt(1) %>  </td>
            	           <td> <%=rs.getString(2) %>  </td>
            	            <td> <%=rs.getString(3) %>  </td>
            	             <td> <%=rs.getFloat(4) %>  </td>
            	       </tr>
            	    	  
            <%	      }//while
            	  
            	  %>
            	    </table>
         <%      }//else
               
               %>
               
               <!--  add home hyperlink  -->
               <br><br> 
                <a href="register.html">home</a>
               
               
               
               <%! public void jspDestroy(){
            	   
            	      try{
            	    	  if(ps1!=null)
            	    		  ps1.close();
            	      }
            	      catch(SQLException se){
            	    	   se.printStackTrace();
            	      }
            	      
            	      try{
            	    	  if(ps2!=null)
            	    		  ps2.close();
            	      }
            	      catch(SQLException se){
            	    	   se.printStackTrace();
            	      }
            	      
            	      try{
            	    	  if(con!=null)
            	    		  con.close();
            	      }
            	      catch(SQLException se){
            	    	   se.printStackTrace();
            	      }
               
               
                  } %>