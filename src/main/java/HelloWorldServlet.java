import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/count")


public class HelloWorldServlet extends HttpServlet {


    //    Finish up the Hello World Servlet
//
//    Create a page that displays "Hello World!" when a user visits /hello

    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        out.println("<h1>Hello, World!</h1>");

        //    Create a page view counter
        //    Create a page that displays a number that goes up by one every time the /count page is viewed.

        count++;

        String reset = request.getParameter("reset");

        if (reset != null) {
            count = 0;
        }

        out.println("<h1>" + count + "</h1>");


    }


}


