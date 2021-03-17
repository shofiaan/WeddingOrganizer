
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
@WebServlet(urlPatterns = {"/InputDataa"})
public class InputDataa extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con = null;
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
            PreparedStatement ps= con.prepareStatement("insert into student values(?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.executeUpdate();
            
            out.println("Data is inputted successfully");
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
