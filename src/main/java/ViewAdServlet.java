import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RyanHarper on 2/2/17.
 */
@WebServlet(name = "ViewAdServlet", urlPatterns = {"/ads/show"})
public class ViewAdServlet extends HttpServlet {

// show the information:
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        //once I have the id I need to make a query to the database;
        //start with the interface..go to the interface Ads
        Ads ads = DaoFactory.getAdsDao();

        Ad ad = ads.find(id);

        request.setAttribute("ad", ad);

        request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);
    }
}
