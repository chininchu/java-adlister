import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewColorPageServlet", urlPatterns = "/viewcolor")

public class ViewColorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // The /viewcolor servlet sets the attribute value as a key pair which then gets forwarded to the jsp page

        String color = req.getParameter("color");
        req.setAttribute("color", color);
        req.getRequestDispatcher("/view-color.jsp")
                .forward(req, resp);

    }


}
