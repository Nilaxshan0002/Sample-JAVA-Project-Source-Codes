<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!-- This directive sets the page language to Java and specifies the character encoding as UTF-8. -->

<!DOCTYPE html>
<html>
<head>
    <title>Agents</title> <!-- Sets the title of the web page. -->

    <style>
        /* 🔹 Navigation Bar Styles */
        .navlist {
            list-style-type: none;
            overflow: hidden;
            border: 1px solid #c0d0e0;
            background-color: #677ff7; /* Navigation bar background color */
            margin: 0;
            width: 100%;
        }

        li {
            float: left; /* Aligns menu items to the left */
            display: inline-block;
        }

        li a {
            text-decoration: none;
            display: block;
            color: #ffffff; /* White text color */
            text-align: center;
            padding: 20px 25px;
        }

        li a:hover:not(.active) {
            background-color: #fffefe;
            color: black; /* Change text color on hover */
        }

        li a.active {
            color: white;
            background-color: #04AA6D; /* Active tab background color */
        }

        body {
            margin: 0;
        }

        /* 🔹 Table Styles */
        .ustable table {
            border: 1px solid black;
            border-collapse: collapse; /* Ensures table borders collapse into one */
            margin-top: 100px;
            margin-left: auto;
            margin-right: auto;
        }

        .ustable {
            position: relative;
        }

        .ustable th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }

        .ustable button {
            margin: 1px;
        }

        .ustable caption {
            padding: 5px;
            font-size: 18px; /* Increases caption font size */
        }

        .ustable th {
            background-color: #677ff7; /* Table header background color */
            color: #faf6f6; /* Table header text color */
        }

        /* Zebra Striping for Table Rows */
        tr:nth-child(even) {
            background-color: #eae7e7;
        }

        /* 🔹 Action Buttons */
        .act {
            background-color: rgb(27, 243, 27); /* Green for Edit */
            color: white;
            border: none;
            border-radius: 6px;
            padding: 5px;
        }

        .deact {
            background-color: rgb(254, 70, 70); /* Red for Delete */
            color: white;
            border: none;
            border-radius: 6px;
            padding: 5px;
        }

        .act:hover {
            background-color: rgb(3, 156, 3); /* Darker green on hover */
        }

        .deact:hover {
            background-color: rgb(191, 6, 6); /* Darker red on hover */
        }

        .act:active {
            background-color: rgb(84, 248, 84); /* Lighter green on click */
        }

        .deact:active {
            background-color: rgb(248, 57, 57); /* Lighter red on click */
        }

        .website-name {
            margin-right: 50px;
            float: right;
            background-color: #1f0b93;
            font-size: 20px;
        }
    </style>
</head>
<body>

    <!-- 🔹 Navigation Menu -->
    <nav class="nav">
        <ul class="navlist">
            <li><a href="UserAdminDashboard.jsp">Dashboard</a></li> <!-- Link to the Admin Dashboard -->
            <li><a href="Customer.jsp">Customers</a></li> <!-- Link to Customer Page -->
            <li><a href="Agent.jsp">Agents</a></li> <!-- Current Page (Agents) -->
            <li><a href="Reports.jsp">Reports</a></li> <!-- Link to Reports Page -->
            <li class="website-name"><a>CareNet</a></li> <!-- Website Name Display -->
        </ul>
    </nav>

    <!-- 🔹 Agent Information Table -->
    <div class="ustable">
        <table class="aptable">
            <caption>Agent Information Table</caption> <!-- Table Title -->
            <tr>
                <th>Agent ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Dept</th>
                <th>Action</th>
            </tr>

            <!-- 🔹 Loop through the agents list and display each agent's details -->
            <c:forEach var="agent" items="${agents}">
                <tr>
                    <td>${agent.agentId}</td> <!-- Display Agent ID -->
                    <td>${agent.firstName}</td> <!-- Display First Name -->
                    <td>${agent.lastName}</td> <!-- Display Last Name -->
                    <td>${agent.email}</td> <!-- Display Email -->
                    <td>${agent.password}</td> <!-- Display Password -->
                    <td>${agent.address}</td> <!-- Display Address -->
                    <td>${agent.phone}</td> <!-- Display Phone Number -->
                    <td>${agent.department}</td> <!-- Display Department -->
                    <td>
                        <button class="act">Edit</button> <!-- Edit Button -->
                        <button class="deact">Delete</button> <!-- Delete Button -->
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
