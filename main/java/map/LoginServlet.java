package map;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public static String name0;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("Luser");
		String pass=request.getParameter("Lpass");
		name0=name;
		int count=0;
		String type="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from info");
			while(rs.next())
			{
				String tempname=rs.getString(1);
				String temppass=rs.getString(2);
				if(tempname.equals(name) && temppass.equals(pass))
				{
					count++;
					type=rs.getString(3);
					break;
				}
			}
			if(count==0)
			{
				out.println("Incorrect email or pass");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			if(count!=0)
			{
				if(type.equals("admin"))
				{
					response.sendRedirect("Admin.jsp");
				}
				if(type.equals("User"))
				{
					response.sendRedirect("User.jsp");
				}
			}
			}
		catch(Exception e)
		{
			
		}
	}

}
