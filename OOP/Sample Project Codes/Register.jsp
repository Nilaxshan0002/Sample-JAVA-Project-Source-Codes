<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
    🔹 This is the User Registration Page for CareNet.
    🔹 It includes a form where users can enter their details to register.
    🔹 The form submits data to `CusRegisterServlet` for backend processing.
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register</title>

    <style>
        /* 🔹 General styling for the body */
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

        /* 🔹 Container box for the registration form */
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

        /* 🔹 Input field styling */
        input[type="text"], input[type="tel"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        /* 🔹 Button group styling */
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

        /* 🔹 Submit button (Register) */
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

    </style>
</head>

<body>
    
    <!-- 🔹 Registration Form Container -->
    <div class="container">
        <center><h1>Register</h1></center>
        
        <!-- 🔹 Registration Form (POST method submits data to CusRegisterServlet) -->
        <form id="registerForm" action="CusRegisterServlet" method="post">
            
            <!-- First Name Input Field -->
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstname" required>
            
            <!-- Last Name Input Field -->
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastname" required>
            
            <!-- Email Input Field -->
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <!-- Phone Number Input Field -->
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" required>

            <!-- Password Input Field -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <!-- 🔹 Link for Agent Registration -->
            <a href="Agent_login.jsp" id="agentLink">Register as an Agent</a>
            <p></p>

            <!-- Register & Reset Buttons -->
            <div class="button-group">
                <input class="submit" type="submit" value="Register">
                <input class="reset" type="reset" value="Reset"> 
            </div>
        </form>
    </div>

</body>
</html>
