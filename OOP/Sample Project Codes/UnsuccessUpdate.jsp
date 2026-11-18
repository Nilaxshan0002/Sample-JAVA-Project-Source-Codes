<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  
    🔹 This JSP page notifies the user that their update attempt was unsuccessful.
    🔹 It displays an error message and provides a button to retry the update process.
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Update Failed</title>

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
            color: rgb(140, 73, 73); /* Dark red text color */
        }

        /* 🔹 Container for the error message */
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
            color: #b53333; /* Dark red for error indication */
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
            background-color: #cc0000; /* Red button */
            color: #fff;
        }

        /* 🔹 Button hover effect */
        input[type="button"]:hover {
            background-color: #b30000;
        }
    </style>
</head>

<body>
    <!-- 🔹 Error message container -->
    <div class="container">
        <h1>Update Failed!</h1>
        <p>Unfortunately, we were unable to update your account details. Please try again later.</p>
        
        <!-- 🔹 Button redirects the user back to the update page -->
        <input type="button" value="Try Again" onclick="location.href='UpdateCustomer.jsp';">
    </div>
</body>
</html>
