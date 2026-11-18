<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- This directive sets the page language to Java and ensures UTF-8 encoding for proper character display. -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"> <!-- Defines character encoding -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title> <!-- Sets the page title -->

    <style>
        /* 🔹 General Page Styling */
        body {
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            background-color: #c0d0e0; /* Light blue background */
            margin: 0;
            padding: 20px;
        }

        /* 🔹 Login Form Container */
        form {
            max-width: 400px; /* Limits form width */
            margin: 0 auto; /* Centers the form */
            background-color: #fff; /* White background */
            padding: 20px;
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
        }

        h2 {
            text-align: center;
            color: #333; /* Dark text color */
        }

        /* 🔹 Input Fields Styling */
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* 🔹 Login Button Styling */
        input[type="button"] {
            background-color: #4CAF50; /* Green button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }

        input[type="button"]:hover {
            background-color: #45a049; /* Darker green on hover */
        }

        /* 🔹 Remember Me Checkbox */
        .remember-me {
            margin-top: 10px;
        }

        /* 🔹 Hyperlink Styling */
        a {
            color: #4CAF50; /* Green links */
            text-decoration: none;
            margin-top: 10px;
            display: inline-block;
        }

        a:hover {
            text-decoration: underline;
        }

        /* 🔹 Error Message */
        .error {
            color: red;
            font-size: 14px;
            display: none; /* Hidden by default */
        }
    </style>
</head>

<body>

    <!-- 🔹 Login Form -->
    <form action="loginuser" method="post" id="loginForm">
        <fieldset>
            <h2>Log in As Agent</h2> <!-- Form title -->
            <div class="login-form">

                <!-- Username Input -->
                <label for="username">User Name:</label>
                <input type="text" id="username" name="username"><br>

                <!-- Password Input -->
                <label for="password">Password:</label>
                <input type="password" id="password" name="password"><br>

                <!-- Error Message for Validation -->
                <span class="error" id="login-error">Please fill in all fields.</span>

                <!-- Login Button -->
                <input type="button" value="LOG IN" onclick="validateLogin()"><br>

                <!-- Remember Me Checkbox -->
                <div class="remember-me">
                    <input type="checkbox" id="remember-me" name="remember-me"> Remember Me<br>
                </div>

                <!-- Forgot Password and Registration Link -->
                <a href="#">Forgot Password?</a><br>
                Don't have an account? <a href="AgentRegister.jsp">Register here</a>
            </div>
        </fieldset>
    </form>

    <!-- 🔹 JavaScript for Login Validation -->
    <script>
        function validateLogin() {
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;
            const loginError = document.getElementById('login-error');

            // 🔹 Check if username and password are empty
            if (username === "" || password === "") {
                loginError.style.display = 'block'; // Show error message
                return;
            }

            loginError.style.display = 'none'; // Hide error message if fields are filled

            // 🔹 Simple alert message (this should be replaced with real login processing)
            alert("Logged in successfully!");
        }
    </script>

</body>

</html>
