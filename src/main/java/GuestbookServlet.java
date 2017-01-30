import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RyanHarper on 1/30/17.
 */
public class GuestbookServlet extends HttpServlet {

    public String lastPost;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // returns the guestbook.jsp page
        // sends fully formed HTML to the user
        request.setAttribute("message", "Welcome to the Guestbook!");
        request.getRequestDispatcher("guestbook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // when getting values from named forms, use request.getParameter("namedParameter")
        // example = String username = request.getParameter("username")
        lastPost = request.getParameter("comment");

        request.setAttribute("lastPost", lastPost);

        request.getRequestDispatcher("guestbook.jsp").forward(request, response);
    }
}


