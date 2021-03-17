/*
*tambah if else lastttt yook bisa
 */

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
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/InputData"})
public class InputData extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
        PrintWriter out = response.getWriter();
        
        Connection con = null;
        String order = request.getParameter("actt");
        if (order == null){
            order = "";
        } else if (order.equals("Basic")){
            order = "Basic 10M";
        } else if (order.equals("Special")){
            order = "Special 15M";
        } else if (order.equals("Platinum")){
            order = "Platinum 20M";
        }

        String fname = request.getParameter("fname");
        String srv = request.getParameter("srv");
        String email = request.getParameter("email");
        String phonee = request.getParameter("pphone");
        String add = request.getParameter("address");
        String bank = request.getParameter("bank");
        String date = request.getParameter("date");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
            PreparedStatement ps= con.prepareStatement("insert into userdata values(?,?,?,?,?,?,?)");
           
            ps.setString(1, fname);
            ps.setString(2, srv);
            ps.setString(3, email);
            ps.setString(4, phonee);
            ps.setString(5, add);
            ps.setString(6, bank);
            ps.setString(7, date);
            ps.executeUpdate();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally
        {
            try{
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
