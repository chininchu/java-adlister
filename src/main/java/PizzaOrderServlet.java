import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "PizzaServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/pizza-order").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(request.getParameter("location"));
        System.out.println(request.getParameter("crust"));
        System.out.println(request.getParameter("size"));
        System.out.println(request.getParameter("crust-flavor"));
        System.out.println(request.getParameter("sauce"));
        System.out.println(request.getParameter("cheese"));
        System.out.println(Arrays.toString(request.getParameterValues("toppings")));


    }


}