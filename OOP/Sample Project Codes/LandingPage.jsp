<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
    🔹 This is the Landing Page for CareNet.
    🔹 It includes a navigation bar, welcome section, services overview, an about-us section, and a footer.
    🔹 The page is styled for responsiveness and accessibility.
-->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page</title>

    <style>
        /* 🔹 General body styling */
        body {
            background-color: #c0d0e0; /* Light blue background */
        }

        /* 🔹 Navigation bar styling */
        .navbar {
            list-style-type: none;
            display: flex;
            justify-content: flex-end; 
            align-items: center;
            margin-right: 30px;
            margin-left: 10px;
        }

        .navbar li {
            margin-left: 5px; 
        }

        .navbar a {
            text-decoration: none;
            color: #334b6b; /* Dark blue text */
            padding: 15px;
            font-size: 25px;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        }

        .navbar a:hover {
            color: #000000;
            background-color:white;
            padding: 15px;
            border-radius: 10px;
        }

        /* 🔹 Logo styling */
        .logo {
            width: 300px; 
            float: left;
            margin-left: 0;
            margin-right: 500px;
            margin-top:0;
        }

        /* 🔹 Header styling */
        header {
            margin-top: 30px;
        }

        /* 🔹 Agent image (floating on the right side) */
        .agentImage {
            width: 40%;
            float: right;
        }

        /* 🔹 Welcome Section */
        .welcome {
            text-align: justify;
            margin-left: 40px;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            background-color: white;
            width: 55%;
            padding: 20px 20px 20px 40px;
            border-radius: 15px;
            margin-top: 5%;
        }

        /* 🔹 Welcome text styling */
        .welcome h1 {
            font-size: 50px;
            color: #3e73b8; /* Blue */
        }

        .welcome h3 {
            font-size: 30px;
            color: #334b6b; /* Dark Blue */
        }

        .welcome h4 {
            font-size: 25px;
            color: rgb(73, 108, 140);
        }

        /* 🔹 Services Section Styling */
        .services-section {
            display: flex;
            justify-content: space-around;
            align-items: center;
            padding: 40px 0;
            background-color: #ffffff;
            width: 100%;
            border-radius: 10px;
        }

        .service {
            text-align: center;
            width: 20%;
        }

        .service img {
            width: 120px;
            height: 120px;
            margin-bottom: 20px;
            margin-top: 20px;
        }

        .service h3 {
            font-size: 23px;
            font-weight: bold;
            color: rgb(73, 108, 140);
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            height: 35px;
        }

        /* 🔹 Responsive Design for Mobile */
        @media (max-width: 768px) {
            .services-section {
                flex-direction: column;
                padding: 20px 0;
            }

            .service {
                margin-bottom: 20px;
                width: 70%;
            }
        }

        /* 🔹 Support Button Styling */
        .support-button {
            display: inline-block;
            padding: 12px 24px;
            background-color: #00aaff;  
            color: white;  
            font-size: 20px;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            border-radius: 8px;  
            transition: background-color 0.3s ease;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            border: none;
        }

        .support-button:hover {
            background-color: #008fcc;  
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2);  
        }

        /* 🔹 About Us Section */
        .about-us {
            padding: 50px;
            background-color: #a3b1c0;
            margin-top: 10px;
            border-radius: 10px;
        }

        .about-us-container {
            display: flex;
            flex-wrap: wrap;
            align-items: center;
        }

        .about-us-image {
            flex: 1;
            max-width: 50%;
        }

        .about-us-image img {
            width: 100%;
            height: auto;
            border-radius: 10px;
            margin-left: 0;
        }

        .about-us-text {
            flex: 1;
            max-width: 65%;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 15px;
        }

        /* 🔹 Footer Styling */
        .footer {
            background-color: #333;
            color: #fff;
            padding: 20px 0;
            font-family: Arial, sans-serif;
            margin-top: 10px;
        }

        .footer-container {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
            padding: 0 20px;
        }

        .footer-section {
            flex: 1;
            margin: 0 20px;
            min-width: 200px;
        }

        .footer-section h3 {
            font-size: 1.5rem;
            margin-bottom: 15px;
        }

        .footer-bottom {
            text-align: center;
            padding: 10px 20px;
            background-color: #222;
        }

    </style>
</head>

<body>

    <!-- 🔹 Navigation Bar -->
    <header>
        <nav>
            <ul class="navbar">
                <li>
                    <img src="images/carenet-logo.png" alt="logo" class="logo">
                </li>
                <li><a href="LandingPage.jsp">Home</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">Feedback</a></li>
                <li><a href="#">About</a></li>
                <li><a href="Register.jsp">Register</a></li>
                <li><a href="Login.jsp">Login</a></li>
            </ul>
        </nav>
    </header>

    <!-- 🔹 Welcome Section -->
    <img src="images/agentAnimation.png" alt="agentImage" class="agentImage">
    <div class="welcome">
        <h1>Welcome to CareNet!</h1>
        <h3>Effortless support, Anytime</h3>
        <h4>Get the help you need quickly and easily with CareNet.</h4>
        <a href="Login.jsp" class="support-button">GET SUPPORT</a>
    </div>

    <!-- 🔹 Services Section -->
    <div class="services-section">
        <div class="service"><img src="images/247.png" alt="Service 1"><h3>24/7 Support</h3></div>
        <div class="service"><img src="images/agent.png" alt="Service 2"><h3>Expert Agents</h3></div>
        <div class="service"><img src="images/ticket.png" alt="Service 3"><h3>Ticket System</h3></div>
        <div class="service"><img src="images/book.png" alt="Service 4"><h3>Knowledge Base</h3></div>
    </div>

    <!-- 🔹 Footer Section -->
    <footer class="footer">
        <div class="footer-bottom">
            <p>&copy; 2024 CareNet. All Rights Reserved.</p>
        </div>
    </footer>

</body>
</html>
