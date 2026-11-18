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
    <title>Create Account</title> <!-- Sets the page title -->

    <!-- 🔹 Simple CSS Styling for the Registration Page -->
    <style>
        /* 🔹 General Page Styling */
        body {
            font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            background-color:#c0d0e0; /* Light blue background */
            margin: 0;
            padding: 20px;
        }

        /* 🔹 Form Container */
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff; /* White background */
            padding: 20px;
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Adds a subtle shadow effect */
        }

        h2 {
            text-align: center;
            color: #333; /* Dark text color */
        }

        /* 🔹 Input Fields Styling */
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* 🔹 Additional Sections (User Type & Registration) */
        .user-type,
        .registration {
            margin-top: 15px;
        }

        /* 🔹 Checkbox Styling */
        input[type="checkbox"] {
            margin-right: 10px;
        }

        /* 🔹 Submit Button Styling */
        input[type="submit"] {
            background-color: #4CAF50; /* Green button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049; /* Darker green on hover */
        }

        /* 🔹 Error Message Styling */
        .error {
            color: red;
            font-size: 14px;
            display: none;
        }

        /* 🔹 Hide Agent Code Field by Default */
        .agent-code {
            display: none;
        }
    </style>
</head>

<body>
    <!-- 🔹 Agent Registration Form -->
    <form id="registrationForm" action="Createagent" method="post" onsubmit="return validateForm()">
        <fieldset>
            <h2>Create Agent Account</h2> <!-- Page heading -->

            <!-- 🔹 Registration Fields -->
            <div class="register">
                <label>Enter First Name:</label>
                <input type="text" id="first-name" name="firstName" required><br>

                <label>Enter Last Name:</label>
                <input type="text" id="last-name" name="lastName" required><br>

                <label>Email:</label>
                <input type="email" id="email" name="email" required><br>

                <label>Department:</label>
                <input type="text" id="Department" name="department" required><br>

                <label>Phone Number:</label>
                <input type="text" id="phone" name="phone" required><br>

                <label>Password:</label>
                <input type="password" id="password" name="password" required><br>

                <label>Confirm Password:</label>
                <input type="password" id="confirm-password" required><br>

                <span class="error" id="password-error">Passwords do not match!</span>
            </div>

            <!-- 🔹 Agent Checkbox -->
            <div class="user-type">
                <input type="checkbox" id="is-agent"> I'm an Agent<br>
                <div class="agent-code">
                    <label>Enter Agent Code:</label>
                    <input type="text" id="agent-code"><br>
                </div>
            </div>

            <!-- 🔹 Terms & Conditions Checkbox -->
            <div class="registration">
                <input type="checkbox" id="terms" required> I agree to the terms and conditions<br>
                <input type="submit" value="Create Account">
            </div>
        </fieldset>
    </form>

    <!-- 🔹 JavaScript Validation -->
    <script>
        // Toggle Agent Code Field Based on Checkbox Selection
        document.getElementById('is-agent').addEventListener('change', function () {
            document.querySelector('.agent-code').style.display = this.checked ? 'block' : 'none';
        });

        // 🔹 Form Validation Function
        function validateForm() {
            const firstName = document.getElementById('first-name').value;
            const lastName = document.getElementById('last-name').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirm-password').value;
            const terms = document.getElementById('terms').checked;
            const isAgent = document.getElementById('is-agent').checked;
            const agentCode = document.getElementById('agent-code').value;
            const passwordError = document.getElementById('password-error');

            // 🔹 Check if passwords match
            if (password !== confirmPassword) {
                passwordError.style.display = 'block';
                return false;
            } else {
                passwordError.style.display = 'none';
            }

            // 🔹 Validate Agent Code if "I'm an Agent" is checked
            if (isAgent && !agentCode) {
                alert("Please enter your agent code.");
                return false;
            }

            // 🔹 Ensure terms & conditions are accepted
            if (!terms) {
                alert("You must agree to the terms and conditions to proceed.");
                return false;
            }

            // 🔹 Success Notification
            alert("Account created successfully!");
            return true;
        }
    </script>
</body>

</html>
