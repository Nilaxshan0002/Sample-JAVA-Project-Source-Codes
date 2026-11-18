<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
    🔹 This is the User Report Page for CareNet.
    🔹 It includes a form for admins to generate reports on users.
    🔹 The form collects data such as new customers, new agents, and total users.
-->

<!DOCTYPE html>
<html>
<head>
    <title>Report</title>

    <style>
       /* 🔹 Navigation bar styles */
       .navlist {
            list-style-type: none;
            overflow: hidden;
            border: 1px solid #c0d0e0;
            background-color: #677ff7; /* Blue navbar */
            margin: 0;
            width: 100%;
        }

        li {
            display: inline-block;
        }

        li a {
            text-decoration: none;
            display: block;
            color: #ffffff;
            text-align: center;
            padding: 20px 25px;
        }

        /* 🔹 Navbar hover and active effects */
        li a:hover:not(.active) {
            background-color: #fffefe;
            color: black;
        }

        li a.active {
            color: white;
            background-color: #04AA6D;
        }

        /* 🔹 General page styles */
        body {
            margin: 0;
        }

        /* 🔹 Styling for the form fields */
        .report-form label {
            display: block;
            margin-bottom: 5px;
            margin-left: 20px;
        }

        .report-form input {
            width: calc(100% - 40px); /* Adjust input width */
            padding: 8px;
            margin-bottom: 10px;
            margin-left: 20px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        /* 🔹 Styling for form buttons */
        .report-form button {
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 20px;
            margin-bottom: 20px;
            margin-top: 20px;
        }

        /* 🔹 Submit button (blue) */
        .report-form button[type="submit"] {
            background-color: #007bff;
            color: #fff;
        }

        /* 🔹 Reset button (red) */
        .report-form button[type="reset"] {
            background-color: #d71e1e;
            color: #ffffff;
        }

        /* 🔹 Styling for the report form container */
        .full-form {
            border: 2px solid;
            width: 400px;
            margin: auto;
            margin-top: 100px;
            margin-bottom: 100px;
            padding: 20px;
            box-sizing: border-box; 
            background-color: rgb(236, 238, 238); /* Light gray */
        }

        /* 🔹 Centering the heading */
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        /* 🔹 Hover effects for buttons */
        button[type="reset"]:hover {
            background-color: #af0909;
        }

        button[type="submit"]:hover {
            background-color: #0667cf;
        }

        /* 🔹 Active effects for buttons */
        button[type="reset"]:active {
            background-color: #f81b1b;
        }
      
        button[type="submit"]:active {
            background-color: #2f90f8;
        }

        /* 🔹 Website name styling */
        .website-name {
            margin-right: 50px;
            float: right;
            background-color: #1f0b93; 
            font-size: 20px;
        }
    </style>
</head>

<body>

  <!-- 🔹 Navigation bar -->
  <nav class="nav">
        <ul class="navlist">
            <li><a href="UserAdminDashboard.jsp">Dashboard</a></li>
            <li><a href="Customer.jsp">Customers</a></li>
            <li><a href="Agent.jsp">Agents</a></li>
            <li><a href="Reports.jsp">Reports</a></li>
            <li class="website-name" href="#"><a>CareNet</a></li>
        </ul>
  </nav>

  <!-- 🔹 Report Form -->
  <div class="full-form" id="reportForm">
      <h2>User Report</h2>
      
      <form class="report-form" method="post" action="ReportServlet">
        
        <!-- 🔹 Report ID -->
        <label for="reportid">Report ID:</label>
        <input type="text" id="reportid" name="reportid"><br>
        
        <!-- 🔹 Report Date -->
        <label for="reportDate">Date:</label>
        <input type="date" id="reportDate" name="rDate"><br>

        <!-- 🔹 New Customers Count -->
        <label for="applicant-count">New Customers Count:</label>
        <input type="number" id="applicant-count" name="newapplicants"><br>

        <!-- 🔹 New Agents Count -->
        <label for="recruiter-count">New Agents Count:</label>
        <input type="number" id="newRec-count" name="newRecCount"><br>

        <!-- 🔹 New Users Count -->
        <label for="newUserCount">New Users Count:</label>
        <input type="number" id="newUser-Count" name="newUserCount"><br>

        <!-- 🔹 Current Users Count -->
        <label for="curUserCount">Current Users Count</label>
        <input type="number" id="curUser-Count" name="curUserCount" required><br>

        <!-- 🔹 Total Users Count -->
        <label for="totalUserCount">Total Users Count:</label>
        <input type="number" id="totalUser-Count" name="totalUserCount"><br>

        <!-- 🔹 Admin ID -->
        <label for="adminid">Admin ID:</label>
        <input type="text" id="adminid" name="adminid"><br>

        <!-- 🔹 Reset and Submit Buttons -->
        <button type="reset">Reset</button>
        <button type="submit">Submit</button>
      </form>
  </div>
   
  <!-- 🔹 JavaScript to show an alert on page load -->
  <script>
      window.onload = function() {
          alert("Weekly Report!");
      };
  </script>

</body>
</html>
