package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

@WebServlet("/uploadurl")
public class UploadServlet extends HttpServlet {
	private static final String  INSERT_JOB_SEEKER_QUERY="INSERT INTO  JOBSEEKER_INFO VALUES(JSID_SEQ.NEXTVAL,?,?,?,?)";
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 //get PrintWriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		 String name=null,addrs=null;
		 List<String> fileNames=null;
		 String photoPath=null, resumePath=null;
		try {
		//create Special Request object
		MultipartFormDataRequest nreq=new MultipartFormDataRequest(req);
		//perform file upload operation
		UploadBean upb=new UploadBean();
		 //sepcify  destination folder to save the files
		upb.setFolderstore("E:/store");
		upb.setBlacklist("*.doc,*.pdf" );  //To specify black list
		upb.setWhitelist("*.docx, *.txt"); //To specify white list
		upb.setMaxfiles(100);
		upb.setFilesizelimit(50*1024*1024);
		// disable overwriting
		upb.setOverwrite(false);
		// complete file upload operation
		upb.store(nreq);
		//read other form comp values
		name=nreq.getParameter("jsName");
		addrs=nreq.getParameter("jsAddrs");
		// get the names of uploaded files
		  Hashtable<String,UploadFile> ht=nreq.getFiles();
		 Enumeration<UploadFile>  e=ht.elements();
		 fileNames=new ArrayList();
		 while(e.hasMoreElements()) {
			 UploadFile file=e.nextElement();
			 fileNames.add(file.getFileName());
		 }
		  photoPath="E:/store/"+fileNames.get(0);
		   resumePath="E:/store/"+fileNames.get(1);
		 
		 pw.println("<br><h1> "+fileNames.get(0)+" , "+fileNames.get(1)+" uploaded successfully </h1>");
		}//try
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<br><h1> Problem in file uploading </h1>");
		}
		//write jdbc code  to insert record to db table
		try {
			//Load JDBC driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Vishal");
				PreparedStatement ps=con.prepareStatement(INSERT_JOB_SEEKER_QUERY);
				){
			 //set values query params
			 ps.setString(1, name);
			 ps.setString(2,addrs);
			 ps.setString(3,photoPath );
			 ps.setString(4, resumePath);
			 //execute the Query
			 int count=ps.executeUpdate();
			 //process the results
			 if(count==0)
				 pw.println("<h1> Job seeker registration failed</h1>");
			 else
				 pw.println("<h1> Job seeker registration completed</h1>");
			 //add home hyperlink
			 pw.println("<br><br><a href='jobseeker_register.html'>home </a>");
				 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public   void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		doGet(req, res);
	}

}
