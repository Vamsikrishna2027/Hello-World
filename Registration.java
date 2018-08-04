

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn=request.getParameter("Firstname");//returns only strings
		String ln=request.getParameter("Secondname");//returns only strings
		String r=request.getParameter("rollno");//returns only strings
		String b=request.getParameter("branch");//returns only strings
		String ph=request.getParameter("phno");//returns only strings
		String em=request.getParameter("email");//returns only strings
		String add=request.getParameter("address");//returns only strings
		String p=request.getParameter("pwd");//returns only strings
		String g=request.getParameter("gender");//returns only strings
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec","root","vamsiy27");
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,fn);
		ps.setString(2,ln);
		ps.setString(3,r);
		ps.setString(4,b);
		ps.setString(5,ph);
		ps.setString(6,em);
		ps.setString(7,add);
		ps.setString(8,p);
		ps.setString(9,g);
		int i=ps.executeUpdate();
		PrintWriter pw=response.getWriter(); 
		if(i>0)
		{
			pw.println("<font color='green'> Registration successful</font>");
		}
		else
		{
			pw.println("<font color='red'> Registration unsuccessful</font>");
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
