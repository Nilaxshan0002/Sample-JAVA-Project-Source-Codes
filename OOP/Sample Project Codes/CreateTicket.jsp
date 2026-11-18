<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
    🔹 This directive defines the page language as Java and sets the character encoding to UTF-8.
    This ensures proper text rendering across different browsers and character sets.
-->

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Create Ticket</title> <!-- Page title shown on the browser tab -->

    <!-- 🔹 CSS Styles for Better UI/UX -->
    <style>

        /* 🔹 Styling for the whole page */
        body {
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            background-color: #c0d0e0; /* Light blue background */
            display: flex;
            justify-content: center; /* Centers the form horizontally */
            align-items: center; /* Centers the form vertically */
            height: 100vh; /* Full viewport height */
            margin: 0;
            color: rgb(73, 108, 140); /* Text color */
        }

        /* 🔹 Form Container Styling */
        .container {
            background: #fff; /* White background */
            padding: 50px;
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
            width: 30%; /* Form width */
            margin-bottom: 30px;
        }

        a {
            color: #008fcc; /* Link color */
        }

        h1 {
            margin-bottom: 20px;
            color: #334b6b; /* Heading color */
            margin-top: 0;
        }

        /* 🔹 Label Styling */
        label {
            display: block;
            margin-bottom: 5px;
        }

        /* 🔹 Input Fields Styling */
        input[type="text"], input[type="date"], textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        /* 🔹 Textarea Specific Styling */
        textarea {
            height: 150px;
            resize: vertical; /* Allows vertical resizing */
        }

        /* 🔹 Button Container */
        .button-group {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }

        /* 🔹 Button Styling */
        input[type="submit"], input[type="reset"] {
            flex: 1; /* Make both buttons equal width */
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 20px;
        }

        /* 🔹 Submit Button Styling */
        input[type="submit"] {
            background-color: #008fcc; /* Blue color */
            color: #fff;
        }

        input[type="submit"]:hover {
            background-color: #017eb4; /* Darker blue on hover */
        }

        /* 🔹 Reset Button Styling */
        input[type="reset"] {
            background-color: #db3615; /* Red color */
            color: #fff;
        }

        input[type="reset"]:hover {
            background-color: #c73417; /* Darker red on hover */
        }

    </style>
</head>

<body>
    
    <!-- 🔹 Ticket Creation Form Container -->
    <div class="container">
        <center><h1>Create Ticket</h1></center> <!-- Form Title -->

        <!-- 🔹 Form for Creating a Ticket -->
        <form id="createTicketForm" action="CreateTicketServlet" method="post">
            <!-- Ticket Subject Field -->
            <label for="subject">Ticket Subject:</label>
            <input type="text" id="subject" name="subject" required>
            
            <!-- Ticket Description Field -->
            <label for="description">Ticket Description:</label>
            <textarea id="description" name="description" required></textarea>
            
            <!-- Ticket Date Field -->
            <label for="date">Ticket Date:</label>
            <input type="date" id="date" name="date" required>
            <p></p>

            <!-- 🔹 Buttons: Submit and Reset -->
            <div class="button-group">
                <input class="submit" type="submit" value="Submit Ticket"> <!-- Submits the form -->
                <input class="reset" type="reset" value="Reset"> <!-- Resets all fields -->
            </div>
        </form>
    </div>

</body>

</html>
