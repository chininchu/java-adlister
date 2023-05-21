package Controllers;


import Models.Author;
import Models.Quote;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BeanServlet", urlPatterns = "/beans")

public class BeanServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Author author1 = new Author(1, "Douglas", "Adams");
        Author author2 = new Author(2, "Mark", "Twain");
        Author author3 = new Author(3, "Kurt", "Vonnegut");

        Author author4 = new Author(4, "Charles", "Dickens");


        Quote quote1 = new Quote(1, author1, "I love deadlines. I love the whooshing noise they make as they go by.");

        Quote quote2 = new Quote(2, author2, "Don't Panic.");
        Quote quote3 = new Quote(2, author3, "Clothes make the man. Naked people have little or no influence on society.");
        Quote quote4 = new Quote(2, author4, "The kindness of people is enough to break one's heart.");


        List<Quote> allQuotes = new ArrayList<>();

        allQuotes.add(quote1);
        allQuotes.add(quote2);
        allQuotes.add(quote3);
        allQuotes.add(quote4);


        req.setAttribute("quotes", allQuotes);

        req.getRequestDispatcher("/bean.jsp").forward(req,resp);
    }
}



