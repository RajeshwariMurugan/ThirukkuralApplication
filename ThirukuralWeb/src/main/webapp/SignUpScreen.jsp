<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Kuralin Kural - Sign Up</title>
<link rel="stylesheet" href="style1.css">
<style>
/* Basic styling for the signup container */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.signup-container {
    background-color: white;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    text-align: center;
}

.input-field {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.signup-btn {
    width: 100%;
    padding: 10px;
    background-color: #283593;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.signup-btn:hover {
    background-color: #1a237e;
}

.error-message {
    color: red;
    font-size: 14px;
    margin-top: 10px;
}

.login-prompt {
    margin-top: 20px;
}

.login-link {
    color: #283593;
    text-decoration: none;
}
</style>
</head>
<body>

    <form action="signup" method="post">
        <div class="signup-container">
            <h1>Sign Up</h1>
            <input type="text" id="username" name="username" placeholder="Full Name" class="input-field" required>
            <input type="email" id="email" name="email" placeholder="Email" class="input-field" required>
            <input type="password" id="password" name="password" placeholder="Password (4 digits)" class="input-field" required>
            <input type="password" id="confirm-password" name="confirm-password" placeholder="Confirm Password" class="input-field" required>
            <input type="submit" class="signup-btn" value="Signup">

            <!-- Display the error message passed from the servlet -->
            <p class="error-message" id="error-message">
                <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
            </p>

            <p class="login-prompt">
                Already have an account? <a href="LoginScreen.jsp" class="login-link">Login</a>
            </p>
        </div>
    </form>

    <script>
        document.querySelector('form').addEventListener('submit', function(event) {
            const name = document.getElementById('username').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirm-password').value;
            const errorMessage = document.getElementById('error-message'); // Get the error message element

            errorMessage.textContent = '';

            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                errorMessage.textContent = "Please enter a valid email address.";
                event.preventDefault(); // Prevent form submission
                return;
            }

            // Check if username is valid (only letters)
            const usernamePattern = /^[a-zA-Z]+$/; // Regex for only alphabets
            if (!usernamePattern.test(name)) {
                errorMessage.textContent = "Username must contain only letters.";
                event.preventDefault(); // Prevent form submission
                return;
            }

            // Check if password is exactly 4 digits
            const passwordPattern = /^\d{4}$/; // Regex for exactly 4 digits
            if (!passwordPattern.test(password)) {
                errorMessage.textContent = "Password must be exactly 4 digits.";
                event.preventDefault(); // Prevent form submission
                return;
            }

            // Check if passwords match
            if (password !== confirmPassword) {
                errorMessage.textContent = "Passwords do not match!";
                event.preventDefault(); // Prevent form submission
                return;
            }
        });
    </script>
</body>
</html>
