import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LossOutcomeServlet", urlPatterns = "/incorrect")
public class LossOutcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("outcome", "You Lost");


        req.getRequestDispatcher("/random-number.jsp").forward(req, resp);


    }
}
