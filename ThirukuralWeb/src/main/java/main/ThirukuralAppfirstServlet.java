package main;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ThirukuralAppfirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ThirukuralAppfirstServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simulate a user check, in a real application check against a database
        if ("Rajii".equals(username) && "4701".equals(password)) {
            request.getRequestDispatcher("Home.html").forward(request, response);
        } else {
        	System.out.println("Invalid Userame");
            response.sendRedirect("LoginScreen.jsp?error=true"); // Redirect to login with error
        }
    }
}
