<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
    🔹 This JSP page allows users to update customer details.
    🔹 It retrieves customer data from request parameters and pre-fills the form fields.
    🔹 The form submits data to the "updateCustomerServlet" for processing.
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Customer</title>
    
    <!-- 🔹 Simple CSS styling -->
    <style>
        /* 🔹 General body styling */
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

        /* 🔹 Container styling */
        .container {
            background: #fff;
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Light shadow effect */
            width: 25%;
            margin-left: 0;
            margin-bottom: 15px;
            font-size: 16px;
        }

        /* 🔹 Link styling */
        a {
            color: #008fcc;
            text-decoration: none;
        }

        /* 🔹 Heading styling */
        h1 {
            margin-bottom: 20px;
            color: #334b6b;
            margin-top: 0;
        }

        /* 🔹 Label styling */
        label {
            display: block;
            margin-bottom: 5px;
        }

        /* 🔹 Input field styling */
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        /* 🔹 Button group for update/reset buttons */
        .button-group {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }

        /* 🔹 Styling for submit and reset buttons */
        input[type="submit"], input[type="reset"] {
            flex: 1;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 20px;
        }

        /* 🔹 Submit button styling */
        input[type="submit"] {
            background-color: #008fcc;
            color: #fff;
        }

        /* 🔹 Submit button hover effect */
        input[type="submit"]:hover {
            background-color: #017eb4;
        }

        /* 🔹 Reset button styling */
        input[type="reset"] {
            background-color: #db3615;
            color: #fff;
        }

        /* 🔹 Reset button hover effect */
        input[type="reset"]:hover {
            background-color: #c73417;
        }

        /* 🔹 Footer section for navigation */
        .footer {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

  <!-- 🔹 Retrieving customer data from request parameters -->
  <%
      String id = request.getParameter("id");         // Get Customer ID
      String firstname = request.getParameter("firstname"); // Get First Name
      String lastname = request.getParameter("lastname");   // Get Last Name
      String email = request.getParameter("email");         // Get Email
      String phone = request.getParameter("phone");         // Get Phone Number
      String password = request.getParameter("password");   // Get Password
  %>
  
    <div class="container">
        <!-- 🔹 Page Heading -->
        <center><h1>Update Customer Details</h1></center>

        <!-- 🔹 Form for updating customer details -->
        <form method="post" action="updateCustomerServlet">
        
            <!-- 🔹 Read-only field for customer ID -->
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="<%= id %>" readonly>
            
            <!-- 🔹 First Name -->
            <label for="firstname">First Name:</label>
            <input type="text" id="firstname" name="firstname" value="<%= firstname %>" required>

            <!-- 🔹 Last Name -->
            <label for="lastname">Last Name:</label>
            <input type="text" id="lastname" name="lastname" value="<%= lastname %>" required>

            <!-- 🔹 Email -->
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= email %>" required>

            <!-- 🔹 Phone -->
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" value="<%= phone %>" required>

            <!-- 🔹 Password -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="<%= password %>" required>

            <!-- 🔹 Button Group -->
            <div class="button-group">
                <input type="submit" value="Update">  <!-- Submit button -->
                <input type="reset" value="Reset">    <!-- Reset button -->
            </div>
        </form>

        <!-- 🔹 Footer Section with Back to Dashboard Link -->
        <div class="footer">
            <p><a href="customerDashboard.jsp">Back to Dashboard</a></p>
        </div>
    </div>
</body>
</html>
