<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Kuralin Kural - Login</title>
<style>
/* General Styles */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

/* Login Container Styles */
.login-container {
    background-color: white;
    padding: 40px;
    border-radius: 15px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
    width: 90%;
    max-width: 400px;
    text-align: center;
}

h1 {
    color: #283593;
    margin-bottom: 20px;
}

.input-field {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 16px;
}

.login-btn {
    background-color: #283593;
    color: white;
    border: none;
    padding: 12px;
    border-radius: 6px;
    cursor: pointer;
    font-size: 16px;
    width: 100%;
    transition: background-color 0.3s;
}

.login-btn:hover {
    background-color: #1a237e;
}

.signup-prompt {
    margin-top: 15px;
    color: #616161;
}

.signup-link {
    color: #283593;
    text-decoration: none;
}

.signup-link:hover {
    text-decoration: underline;
}

.error-message {
    color: red;
    margin-top: 10px;
}
</style>
</head>
<body>
    <form action="login" method="post">
        <div class="login-container">
            <h1>Login</h1>
            <input type="text" id="username" name="username"
                placeholder="Username or Email" class="input-field" required>
            <input type="password" id="password" name="password"
                placeholder="Password" class="input-field" required> 
            <input type="submit" class="login-btn" value="Log In">
            <p class="error-message">
             
            </p>
            <p class="signup-prompt">
                Don't have an account? <a href="SignUpScreen.jsp"
                    class="signup-link">Sign Up</a>
            </p>
        </div>
    </form>
</body>
</html>
