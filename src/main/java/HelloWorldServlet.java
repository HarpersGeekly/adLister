
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// urlPatterns is a set of paths
@WebServlet(name = "HelloServlet", urlPatterns = "/hello") /* where the path will be: somesite/hello */
public class HelloWorldServlet extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        if (name != null) {
            out.println("<h1>Hello, " + name + "</h1>");
        } else {
            out.println("<h1>Hello World</h1>");
        }
        // you could also getServletName() in place of name and delete String name = request getParameter("name")
        counter += 1;
        response.getWriter().println("<h3>Number of page visits: " + counter + ".</h3>");



    }
}

//    Create a page that displays "Hello World!" when a user visits /hello
//
//        Bonus
//
//        Make the page say "Hello, <name>!" if name is passed as part of the query string, otherwise default to "Hello, World!"
//
//        Learn about the .getParameter method on the request object.
//
//        Create a page view counter
//
//        Create a page that displays a number that goes up by 1 everytime the /count page is viewed.
//
//        Bonus
//
//        Allow the user to pass a parameter in the query string to reset the counter.