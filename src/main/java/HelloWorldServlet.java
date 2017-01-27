
import java.io.*;
import java.util.Scanner;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Object counter = request.getAttribute("counter");
        int count;

        if (counter != null) {
            count = Integer.parseInt((String) counter);
            count++;

        } else {
            count = 1;
        }

        request.setAttribute("counter", count);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, " + getServletName() + "</h1>");
        out.println("<p>Page Counter: " + count + "</p>");

    }
}
