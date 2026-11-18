<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  
    🔹 This JSP page confirms that the user's profile has been successfully updated.
    🔹 It displays a success message and provides a button to return to the customer dashboard.
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Update Success</title>

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

        /* 🔹 Container for success message */
        .container {
            background: #fff; /* White background */
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Light shadow effect */
            text-align: center;
            width: 25%;
        }

        /* 🔹 Header styling */
        h1 {
            margin-bottom: 20px;
            color: #334b6b;
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
    <!-- 🔹 Success message container -->
    <div class="container">
        <h1>Update Successfully!</h1>
        <p>Your profile has been updated.</p>
        
        <!-- 🔹 Button redirects the user to the customer dashboard -->
        <input type="button" value="Done" onclick="location.href='customerDashboard.jsp';">
    </div>
</body>
</html>
