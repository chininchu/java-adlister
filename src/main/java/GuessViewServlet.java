import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

import static java.lang.Math.*;

@WebServlet(name = "GuessViewServlet", urlPatterns = "/guess")


public class GuessViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/guess-random-number.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // This method will redirect and pass any input to the next servlet

        int userInput = Integer.parseInt(req.getParameter("userinput"));

        Random random = new Random();
        int rand = random.nextInt(3) + 1;

        System.out.println(rand);
        System.out.println(userInput);




        if (userInput == rand) {

            resp.sendRedirect("/correct");


        } else {

            resp.sendRedirect("/incorrect");


        }


    }
}
