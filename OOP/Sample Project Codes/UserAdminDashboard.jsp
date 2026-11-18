<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<title>Dashboard</title>

    <style>
        /* 🔹 Navigation Bar Styling */
        .navlist {
            list-style-type: none; /* Remove default list styling */
            overflow: hidden;
            border: 1px solid #c0d0e0;
            background-color: #677ff7; /* Navigation bar background color */
            font-family: Franklin Gothic Medium;
            margin: 0;
            width: 100%;
        }

        /* 🔹 Navigation Items Styling */
        li {
            float: left;
            display: inline-block;
        }

        li a {
            text-decoration: none;
            display: block;
            color: #c0d0e0;
            text-align: center;
            padding: 20px 25px;
        }

        /* 🔹 Hover Effect for Navigation Items */
        li a:hover:not(.active) {
            background-color: #c0d0e0;
            font-family: Franklin Gothic Medium;
            color: black;
        }

        /* 🔹 Dashboard Summary Boxes */
        .user-box,
        .recruiter-box,
        .applicant-box {
            border-radius: 8px;
            padding: 20px;
            padding-top: 70px;
            text-align: center;
            height: 250px;
            width: 200px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            margin-top: 150px;
            display: inline-block;
        }

        body {
            margin: 0;
        }

        /* 🔹 Styling for User Count Box */
        .user-box {
            margin-left: 300px;
            background-color:#0892d0;
            font-family: Franklin Gothic Medium;
        }

        /* 🔹 Styling for Customer Count Box */
        .recruiter-box {
            margin-left: 100px;
            background-color: #ff0000;
            font-family: Franklin Gothic Medium;
        }

        /* 🔹 Styling for Agent Count Box */
        .applicant-box {
            margin-left: 100px;
            background-color: #20e320;
            font-family: Franklin Gothic Medium;
        }

        /* 🔹 Image Styling for Dashboard Summary Boxes */
        .user-box img, .recruiter-box img, .applicant-box img {
            width: 100px;
        }

        /* 🔹 Styling for Box Headers */
        h2 {
            margin-bottom: 10px;
            color: #c0d0e0;
        }

        /* 🔹 Styling for Count Text in Boxes */
        p {
            font-size: 24px;
            color: #c0d0e0;
            padding: 10px;
            border: 2px solid black;
        }

        /* 🔹 Website Name Styling in Navbar */
        .website-name {
            margin-right: 50px;
            float: right;
            background-color: #1f0b93; 
            font-family: Franklin Gothic Medium;
            font-size: 20px;
        }

        /* 🔹 Modal Box for Welcome Message */
        .wMsg {
            display: none; /* Initially hidden */
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); 
            font-family: Franklin Gothic Medium;
            z-index: 1000; 
            justify-content: center;
            align-items: center;
        }

        /* 🔹 Styling for Modal Box Content */
        .modal-content {
            background-color: #c0d0e0;
            font-family: Franklin Gothic Medium;
            padding: 10px;
            text-align: center;
            border-radius: 20px;
            width: 250px;
        }

        /* 🔹 Styling for "Okay" Button in Modal */
        .modal-button {
            margin-top: 20px;
            margin-bottom: 10px;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            background-color: #007bff; 
            font-family: Franklin Gothic Medium;
            color: #c0d0e0;
        }

        /* 🔹 Styling for Welcome Message in Modal */
        .welcmsg {
            border: none;
            color: black;
            padding: 0;
        }

        /* 🔹 Admin Mask Image in Modal */
        .adminmask {
            padding: 0;
            width: 70px;
            margin-top: 20px;
        }  
        
    </style>
</head>
<body>

    <!-- 🔹 Navigation Bar -->
    <nav class="nav">
        <ul class="navlist">
            <li><a href="UserAdminDashboard.jsp">Dashboard</a></li>
            <li><a href="Customer.jsp">Customers</a></li>
            <li><a href="Agent.jsp">Agents</a></li>
            <li><a href="Reports.jsp">Reports</a></li>
            <li class="website-name" href="#"><a>CareNet</a></li>
        </ul>
    </nav>

    <!-- 🔹 Summary Boxes -->
    <div class="user-box">
        <h2>Total Users</h2>
        <p id="user-count">20</p> <!-- Display total users -->
    </div>
    
    <div class="recruiter-box">
        <h2>Total Customers</h2>
        <p id="recruiter-count">10</p> <!-- Display total customers -->
    </div>
    
    <div class="applicant-box">
        <h2>Total Agents</h2>
        <p id="applicant-count">10</p> <!-- Display total agents -->
    </div>

    <!-- 🔹 Welcome Message Modal -->
    <div id="welcome" class="wMsg">
        <div class="modal-content">
            <img src="mask.png" class="adminmask">
            <p class="welcmsg">Welcome, Admin!</p>
            <button id="okayButton" class="modal-button">Okay</button>
        </div>
    </div>

    <!-- 🔹 JavaScript for Welcome Message Modal -->
    <script>
        // Show the welcome message when the page loads
        window.onload = function () {
            document.getElementById("welcome").style.display = "flex";
        };

        // Hide the welcome message when the "Okay" button is clicked
        document.getElementById("okayButton").onclick = function () {
            document.getElementById("welcome").style.display = "none";
        };
    </script>

</body>
</html>
