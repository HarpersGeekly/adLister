import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RyanHarper on 1/31/17.
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/hello-servlet"})
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String name = "Ryan";

        if (request.getParameter("name") !=null){
            name = request.getParameter("name");
        }
        List languages = Arrays.asList("HTML", "CSS", "Javascript", "Java");

        //variables passed to the view
        request.setAttribute("name", name);
        request.setAttribute("age", new Integer(31));
        request.setAttribute("languages", languages);

        request.getRequestDispatcher("hello-world.jsp").forward(request, response);

    }
}
