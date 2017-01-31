import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by RyanHarper on 1/31/17.
 */
@WebServlet(name = "AdsServlet", urlPatterns = "/ads")
public class AdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // make a list of all the ads:
        List<Ad> ads = DaoFactory.getAdsDao().all();

        //assign that variable to the data sent to the view:
        request.setAttribute("ads", ads); // value that the variable represents. Harmonize them.

        //provide the path to the page that will render this...
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}
