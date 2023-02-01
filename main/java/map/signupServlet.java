package map;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupServlet() {
        super();
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
		String name=request.getParameter("Sname");
		String password=request.getParameter("Spass");
		String Confirmpass=request.getParameter("Scpass");
		if(!password.equals(Confirmpass)) {
			out.println("password mismatch re-enter the password");
			request.getRequestDispatcher("signup.jsp").include(request, response);
		}
		if(password.equals(Confirmpass)){
		String type="User";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
			String sqlquery00="select * from info";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sqlquery00);
			int count=0;
			while(rs.next())
			{
				String alreadyused=rs.getString(1);
				if(name.equals(alreadyused))
				{	
					count++;
					break;
				}
			}
			if(count!=0)
			{
				out.println("Username already in use");
				request.getRequestDispatcher("signup.jsp").include(request, response);
			}
			if(count==0) 
			{
			String sqlquery="insert into info values(?,?,?)";
			PreparedStatement pst=con.prepareStatement(sqlquery);
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, type);
			pst.executeUpdate();
			response.sendRedirect("index.jsp");
			}
			
		}
		catch(Exception e)
		{
			
		}
		}
	}



	}


