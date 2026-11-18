<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  
    🔹 This JSP page allows users to update their profile information.
    🔹 It includes form fields for first name, last name, email, department, phone number, and password.
    🔹 Users can indicate if they are an agent by checking a checkbox, which reveals an additional input for the agent code.
    🔹 The form includes basic validation using JavaScript.
-->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
    
    <!-- 🔹 Simple CSS for styling the page -->
    <style>
        /* 🔹 General body styling */
        body {
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            background-color: #c0d0e0; /* Light blue background */
            margin: 0;
            padding: 20px;
        }

        /* 🔹 Form container styling */
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Light shadow effect */
        }

        /* 🔹 Heading styling */
        h2 {
            text-align: center;
            color: #333;
        }

        /* 🔹 Input field styling */
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

        /* 🔹 Checkbox sections */
        .user-type,
        .registration {
            margin-top: 15px;
        }

        /* 🔹 Checkbox spacing */
        input[type="checkbox"] {
            margin-right: 10px;
        }

        /* 🔹 Submit button styling */
        input[type="submit"] {
            background-color: #4CAF50; /* Green button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        /* 🔹 Submit button hover effect */
        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* 🔹 Error message styling */
        .error {
            color: red;
            font-size: 14px;
            display: none;
        }

        /* 🔹 Initially hide the agent code input field */
        .agent-code {
            display: none;
        }
    </style>
</head>

<body>

    <!-- 🔹 Profile Update Form -->
    <form id="editprofileForm" action="updateProfileServlet" method="post" onsubmit="return validateForm();">
        <fieldset>
            <h2>Update Profile</h2>

            <div class="edit">
                <label>Enter First Name:</label>
                <input type="text" id="first-name" name="firstName" required><br>

                <label>Enter Last Name:</label>
                <input type="text" id="last-name" name="lastName" required><br>

                <label>Email:</label>
                <input type="email" id="email" name="email" required><br>

                <label>Department:</label>
                <input type="text" id="department" name="department" required><br>

                <label>Phone Number:</label>
                <input type="text" id="phone" name="phone" required><br>

                <label>Password:</label>
                <input type="password" id="password" name="password" required><br>

                <label>Confirm Password:</label>
                <input type="password" id="confirm-password" required><br>
                
                <!-- 🔹 Error message for password mismatch -->
                <span class="error" id="password-error">Passwords do not match!</span>
            </div>

            <!-- 🔹 Checkbox for agent selection -->
            <div class="user-type">
                <input type="checkbox" id="is-agent" name="isAgent"> I'm an Agent<br>

                <!-- 🔹 Agent code input field (hidden by default) -->
                <div class="agent-code">
                    <label>Enter Agent Code:</label>
                    <input type="text" id="agent-code" name="agentCode"><br>
                </div>
            </div>

            <!-- 🔹 Terms and conditions agreement -->
            <div class="registration">
                <input type="checkbox" id="terms" required> I agree to the terms and conditions<br>
                <input type="submit" value="Save Changes">
            </div>
        </fieldset>
    </form>

    <!-- 🔹 JavaScript for form validation and interactivity -->
    <script>
        // 🔹 Show or hide agent code input field based on checkbox selection
        document.getElementById('is-agent').addEventListener('change', function () {
            document.querySelector('.agent-code').style.display = this.checked ? 'block' : 'none';
        });

        // 🔹 Form validation function
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

            // 🔹 If user is an agent, ensure they enter an agent code
            if (isAgent && !agentCode) {
                alert("Please enter your agent code.");
                return false;
            }

            // 🔹 Ensure the user agrees to the terms
            if (!terms) {
                alert("You must agree to the terms and conditions to proceed.");
                return false;
            }

            // 🔹 Show success message (can be replaced with a server response)
            alert("Profile updated successfully!");
            return true;
        }
    </script>

</body>
</html>
