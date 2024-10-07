package main;

// Import necessary libraries
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignUpServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        String errorMessage = ""; // Variable to hold error messages

        // Perform validations
        if (username == null || username.isEmpty() || !isValidUsername(username)) {
            errorMessage = "Username cannot be empty or contain symbols/numbers.";
        } else if (password == null || password.isEmpty() || password.length() != 4 || !isValidPassword(password)) {
            errorMessage = "Password must be exactly 4 digits.";
        } else if (!password.equals(confirmPassword)) {
            errorMessage = "Passwords do not match.";
        }

        if (!errorMessage.isEmpty()) {
            // If there are error messages, forward to sign-up page with the error
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        } else {
            // If all validations pass, forward to home page or welcome page
            request.getRequestDispatcher("Home.html").forward(request, response);
        }
    }

    // Validate username: should not contain numbers or special characters
    private boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z]+"); // Only allows alphabets
    }

    // Validate password: should be exactly 4 digits
    private boolean isValidPassword(String password) {
        return password.matches("\\d{4}"); // Only allows exactly 4 digits
    }
}
