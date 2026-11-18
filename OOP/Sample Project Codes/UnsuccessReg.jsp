<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  
    🔹 This JSP page informs the user that their registration attempt was unsuccessful.
    🔹 It displays an error message and provides a button to retry the registration process.
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration Unsuccessful</title>

    <style>
        /* 🔹 Styling for the entire page */
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

        /* 🔹 Container for error message */
        .container {
            background: #fff; /* White background */
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Light shadow effect */
            text-align: center;
            width: 25%;
        }

        /* 🔹 Header styling (red color for error message) */
        h1 {
            margin-bottom: 20px;
            color: #db3615; /* Red for error indication */
            margin-top: 0;
        }

        /* 🔹 Paragraph styling */
        p {
            font-size: 16px;
            margin-bottom: 20px;
        }

        /* 🔹 Button styling */
        input[type="button"] {
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 20px;
            background-color: #008fcc; /* Blue button */
            color: #fff;
        }

        /* 🔹 Button hover effect */
        input[type="button"]:hover {
            background-color: #017eb4;
        }
        
    </style>
</head>

<body>
    <!-- 🔹 Error message container -->
    <div class="container">
        <h1>Registration Unsuccessful!</h1>
        <p>We're sorry, something went wrong during registration. Please try again or contact support for assistance.</p>
        
        <!-- 🔹 Button redirects the user back to the registration page -->
        <input type="button" value="Try Again" onclick="location.href='Register.jsp';">
    </div>
</body>
</html>
