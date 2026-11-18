<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
    🔹 This directive defines the page language as Java and sets the character encoding to UTF-8.
    This ensures proper text rendering across different browsers and character sets.
-->

<!DOCTYPE html>
<html>

<head>

    <title>Customers</title> <!-- Page title shown on the browser tab -->

    <!-- 🔹 CSS Styles for Navigation Bar and Table -->
    <style>
        /* 🔹 Navigation Bar Styling */
        .navlist {
            list-style-type: none;
            overflow: hidden;
            border: 1px solid #c0d0e0;
            background-color: #677ff7; /* Blue navigation bar */
            margin: 0;
            width: 100%;
        }

        li {
            float: left;
            display: inline-block;
        }

        li a {
            text-decoration: none;
            display: block;
            color: #ffffff; /* White text */
            text-align: center;
            padding: 20px 25px;
        }

        li a:hover:not(.active) {
            background-color: #fffefe; /* White background on hover */
            color: black;
        }

        /* 🔹 Corrected Active Link Styling */
        li a.active {
            color: white;
            background-color: #04AA6D; /* Green background for active tab */
        }

        body {
            margin: 0;
        }

        /* 🔹 Table Styling */
        .ustable table {
            border: 1px black solid;
            border-collapse: collapse;
            margin-top: 100px;
            margin-left: auto;
            margin-right: auto;
        }

        .ustable {
            position: relative;
        }

        .ustable th, td {
            border: 1px black solid;
            padding: 10px;
            text-align: center;
        }

        .ustable button {
            margin: 1px;
        }

        .ustable caption {
            padding: 5px;
            font-size: 20px;
            font-weight: bold;
        }

        .ustable th {
            background-color: #677ff7; /* Blue header */
            color: #faf6f6;
        }

        /* 🔹 Alternate Row Coloring for Readability */
        tr:nth-child(even) {
            background-color: #eae7e7;
        }

        /* 🔹 Edit and Delete Button Styling */
        .act {
            background-color: rgb(27, 243, 27); /* Green button for Edit */
            color: white;
            border: none;
            border-radius: 6px;
            padding: 5px;
            cursor: pointer;
        }

        .deact {
            background-color: rgb(254, 70, 70); /* Red button for Delete */
            color: white;
            border: none;
            border-radius: 6px;
            padding: 5px;
            cursor: pointer;
        }

        .act:hover {
            background-color: rgb(3, 156, 3);
        }

        .deact:hover {
            background-color: rgb(191, 6, 6);
        }

        .act:active {
            background-color: rgb(84, 248, 84);
        }

        .deact:active {
            background-color: rgb(248, 57, 57);
        }
        
        /* 🔹 Website Name Styling */
        .website-name {
            margin-right: 50px;
            float: right;
            background-color: #1f0b93;
            font-size: 20px;
            padding: 20px 25px;
            color: white;
        }

    </style>

</head>

<body>
    
    <!-- 🔹 Navigation Bar -->
    <nav class="nav">
        <ul class="navlist">
            <li><a href="UserAdminDashboard.jsp">Dashboard</a></li>
            <li><a href="Customer.jsp" class="active">Customers</a></li> <!-- Marked as active -->
            <li><a href="Agent.jsp">Agents</a></li>
            <li><a href="Reports.jsp">Reports</a></li>
            <li class="website-name"><a>CareNet</a></li> <!-- Website name -->
        </ul>
    </nav>

    <!-- 🔹 Customer Table -->
    <div class="ustable">
        <table class="rtable">
            <caption>Customers Information Table</caption> <!-- Table Title -->
            <tr>
                <th>Customer ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Password</th> <!-- ⚠️ Consider Hiding Passwords for Security -->
                <th>Address</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>

            <!-- 🔹 Dynamic Data Population from Servlet -->
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.password}</td> <!-- ⚠️ Displaying passwords is a security risk -->
                    <td>${customer.address}</td>
                    <td>${customer.phone}</td>
                    <td>
                        <button class="act">Edit</button> <!-- Edit Button -->
                        <button class="deact">Delete</button> <!-- Delete Button -->
                    </td>
                </tr>
            </c:forEach>
            <!-- The above loop dynamically creates rows for each customer record in the database -->
        </table>
    </div>

</body>

</html>
