

<%! 
		public void jspinti() {
		
		System.out.println("hello, how are u?");
		ServletConfig cg=getServletConfig();
		ServletContext sc=getServletContext();
		System.out.println("config obj class name:: "+cg.getClass());
		System.out.println("application obj class name:: "+sc.getClass());
		
		System.out.println("p1 inti param value ::"+cg.getInitParameter("p1"));
		System.out.println("p2 inti param value ::"+cg.getInitParameter("p2"));
		
		System.out.println("c1 context param value ::"+sc.getInitParameter("c1"));
	
}%>

<b>welcome to jsp pages</b>

<b>Good Morning....</b>