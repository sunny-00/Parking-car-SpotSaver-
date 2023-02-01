package map;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addlocation
 */
@WebServlet("/addlocation")
public class addlocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addlocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		double price=Double.parseDouble(request.getParameter("price"));
		int spot=Integer.parseInt(request.getParameter("spot"));
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
		String sqlquery="insert into location(city,address,spot,price) values(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sqlquery);
		pst.setString(1, city);
		pst.setString(2, address);
		pst.setInt(3, spot);
		pst.setDouble(4, price);
		pst.executeUpdate();
		out.println("location has been added");
		response.sendRedirect("addlocation.jsp");
		}
		catch(Exception e)
		{
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
