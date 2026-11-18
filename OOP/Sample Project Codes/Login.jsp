<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
    🔹 This is the Login Page for CareNet.
    🔹 It includes a login form with email and password fields.
    🔹 The form submits data to `loginServlet` for backend authentication.
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <style>
        /* 🔹 General styling for body */
        body {
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            background-color: #c0d0e0; /* Light blue background */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: rgb(73, 108, 140);
        }

        /* 🔹 Container box for the login form */
        .container {
            background: #fff;
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 25%;
            margin-left: 0;
            margin-bottom: 30px;
        }

        /* 🔹 Hyperlink styling */
        a {
            color: #008fcc;
            text-decoration: none;
        }

        /* 🔹 Title styling */
        h1 {
            margin-bottom: 20px;
            color: #334b6b;
            margin-top: 0;
        }

        /* 🔹 Label styling */
        label {
            display: block;
            margin-bottom: 5px;
            font-size: 20px;
        }

        /* 🔹 Input fields styling */
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        /* 🔹 Button group (login & reset) styling */
        .button-group {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }

        /* 🔹 Submit & Reset button styles */
        input[type="submit"], input[type="reset"] {
            flex: 1;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 20px;
        }

        /* 🔹 Submit button (Login) */
        input[type="submit"] {
            background-color: #008fcc;
            color: #fff;
        }

        input[type="submit"]:hover {
            background-color: #017eb4;
        }

        /* 🔹 Reset button */
        input[type="reset"] {
            background-color: #db3615;
            color: #fff;
        }

        input[type="reset"]:hover {
            background-color: #c73417;
        }

        /* 🔹 Footer text styling */
        .footer {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>

<body>

    <!-- 🔹 Login Form Container -->
    <div class="container">
        <center><h1>Login</h1></center>
        
        <!-- 🔹 Login Form (POST method submits data to loginServlet) -->
        <form id="loginForm" method="post" action="loginServlet">
            
            <!-- Email Input Field -->
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <!-- Password Input Field -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <!-- Login & Reset Buttons -->
            <div class="button-group">
                <input type="submit" value="Login">
                <input type="reset" value="Reset">
            </div>
        </form>

        <!-- 🔹 Link to Registration Page -->
        <div class="footer">
            <p>Don't have an account? <a href="Register.jsp">Register here</a></p>
        </div>
    </div>

</body>
</html>
