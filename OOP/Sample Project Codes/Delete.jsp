<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
    🔹 This page allows users to delete their account.
    🔹 It includes a simple form with email, password verification, and a confirmation checkbox.
    🔹 Uses JavaScript validation to ensure correct password and confirmation before submission.
-->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Account</title>

    <style>
        /* 🔹 Basic styles for a clean and user-friendly UI */
        body {
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            background-color: #f2dede; /* Light red background to indicate danger */
            margin: 0;
            padding: 20px;
        }

        /* 🔹 Styling the form container */
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* 🔹 Heading style */
        h2 {
            text-align: center;
            color: #a94442; /* Dark red color for emphasis */
        }

        /* 🔹 Input fields styling */
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* 🔹 Styling for error message */
        .error {
            color: red;
            font-size: 14px;
            display: none; /* Initially hidden */
        }

        /* 🔹 Delete reason (Optional text area) */
        .delete-reason {
            margin-top: 15px;
        }

        .delete-reason textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* 🔹 Submit button styling */
        input[type="submit"] {
            background-color: #d9534f; /* Red delete button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #c9302c;
        }
    </style>
</head>

<body>

    <!-- 🔹 Delete Account Form -->
    <form id="deleteAccount" action="" method="post" onsubmit="return validateForm()">
        <fieldset>
            <h2>Delete Account</h2>
            <div class="delete">
                <!-- 🔹 Email Input -->
                <label>Email:</label>
                <input type="email" id="email" required><br>

                <!-- 🔹 Password Input -->
                <label>Password:</label>
                <input type="password" id="password" required><br>

                <!-- 🔹 Password Error Message -->
                <span class="error" id="password-error">Incorrect password!</span>
            </div>

            <!-- 🔹 Checkbox Confirmation -->
            <div class="confirmation">
                <input type="checkbox" id="confirm-delete" required> My account will be permanently deleted.<br>
                <input type="submit" value="Delete Account">
            </div>
        </fieldset>
    </form>

    <!-- 🔹 JavaScript for Form Validation -->
    <script>
        function validateForm() {
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const confirmDelete = document.getElementById('confirm-delete').checked;
            const passwordError = document.getElementById('password-error');

            // 🔹 Check password (Temporary validation: Replace with backend verification)
            if (password !== "12345") { // Change "12345" to real password verification
                passwordError.style.display = 'block';
                return false;
            } else {
                passwordError.style.display = 'none';
            }

            // 🔹 Ensure user has checked the confirmation box
            if (!confirmDelete) {
                alert("You must confirm the account deletion.");
                return false;
            }

            // 🔹 Success message (Replace this with actual form submission)
            alert("Your account has been successfully deleted.");
            return true;
        }
    </script>

</body>

</html>
