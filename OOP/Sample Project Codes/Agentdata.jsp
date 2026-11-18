<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
    🔹 This directive sets the page language to Java and ensures UTF-8 encoding 
    for proper character display and compatibility with different languages.
-->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"> <!-- Defines character encoding -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agent Details</title> <!-- Sets the page title -->

    <!-- 🔹 Simple CSS Styling for the Agent Profile Page -->
    <style>
        /* 🔹 General Page Styling */
        body {
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            background-color: #c0d0e0; /* Light blue background */
            margin: 0;
            padding: 20px;
        }

        /* 🔹 Agent Details Form Container */
        form {
            max-width: 400px; /* Limits form width */
            margin: 0 auto; /* Centers the form */
            background-color: #fff; /* White background */
            padding: 20px;
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Adds a subtle shadow effect */
        }

        h2 {
            text-align: center;
            color: #333; /* Dark text color */
        }

        /* 🔹 Agent Data Display Section */
        .agent-data {
            display: flex;
            flex-direction: column;
            gap: 15px; /* Adds spacing between fields */
        }

        .agent-data label {
            font-weight: bold;
            color: #333;
            display: inline-block;
            width: 120px; /* Ensures alignment of labels */
        }

        .agent-data span {
            color: #666; /* Grey color for values */
        }

        /* 🔹 Data Field Row */
        .data-field {
            display: flex;
            justify-content: space-between;
        }

        .data-field span {
            flex-grow: 1;
            padding-left: 10px;
            color: #333;
        }

        /* 🔹 Edit Profile Button */
        input[type="button"] {
            background-color: #4CAF50; /* Green button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 20px;
        }

        input[type="button"]:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    </style>
</head>

<body>
    <!-- 🔹 Agent Details Form -->
    <form id="registrationForm" action="" method="post">
        <fieldset>
            <h2>Agent Details</h2> <!-- Page heading -->

            <!-- 🔹 Agent Information Fields -->
            <div class="agent-data">
                <div class="data-field">
                    <label>First Name:</label>
                    <span>John</span> <!-- Display the agent's first name -->
                </div>
                <div class="data-field">
                    <label>Last Name:</label>
                    <span>Doe</span> <!-- Display the agent's last name -->
                </div>
                <div class="data-field">
                    <label>Email:</label>
                    <span>john.doe@example.com</span> <!-- Display the agent's email -->
                </div>
                <div class="data-field">
                    <label>Department:</label>
                    <span>IT Department</span> <!-- Display the agent's department -->
                </div>
                <div class="data-field">
                    <label>Phone Number:</label>
                    <span>+123456789</span> <!-- Display the agent's phone number -->
                </div>
                <div class="data-field">
                    <label>Agent Code:</label>
                    <span>AG101</span> <!-- Display the agent's unique code -->
                </div>

                <!-- 🔹 Edit Profile Button -->
                <input type="button" value="Edit Profile">
                <!-- This button can be linked to an edit profile page where the agent can update their details -->
            </div>
        </fieldset>
    </form>
</body>

</html>
