import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RyanHarper on 1/31/17.
 */
@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/login", "/profile"})
public class AuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equalsIgnoreCase("admin") &&
            password.equalsIgnoreCase("password")) {
//            PrintWriter writer = response.getWriter();
//            writer.println("<!DOCTYPE html>");
//            writer.println("<html>");
//            writer.println("<head>");
//            writer.println("</head>");
//            writer.println("<body>");
//            writer.println("<h1>Hi Admin!</h1>");
//            writer.println("<p>This is your profile</p>");
//            writer.println("</body>");
//            writer.println("</html>");
//
            // lets clean this up a bit...and rather, instead, call another file to handle the Presentation:
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login"); //if the username and password isn't admin and password it redirects back to login
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        // creating the form first:
//        PrintWriter writer = response.getWriter();
//        writer.println("<!DOCTYPE html>");
//        writer.println("<html>");
//        writer.println("<head>");
//        writer.println("</head>");
//        writer.println("<body>");
//        writer.println("<form action='/profile' method='post'>");
//        writer.println("<label>Username</label>");
//        writer.println("<input type='text' name='username'>");
//        writer.println("<label>Password</label>");
//        writer.println("<input type='password' name='password'>");
//        writer.println("<input type='submit' name='login' value='Login'>");
//        writer.println("</form>");
//        writer.println("</body>");
//        writer.println("</html>");

        //lets clean this up a bit...and rather, instead, call another file to handle the Presentation:
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
