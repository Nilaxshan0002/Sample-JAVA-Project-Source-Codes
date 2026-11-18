<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
    🔹 This directive sets the page content type to UTF-8 to support special characters 
    and defines Java as the scripting language.
-->
<!DOCTYPE html>
<html>

<head>
    <title>Customer Dashboard</title>

    <!-- 🔹 CSS Styles for Layout, Navigation, Sections, and Buttons -->
    <style>
        /* 🔹 General Page Styling */
        body {
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #c0d0e0; /* Light blue background */
        }

        /* 🔹 Header Styling */
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
        }

        .logo {
            width: 15%;
        }

        /* 🔹 Navigation Bar Styling */
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
            color: #334b6b;
            padding: 15px;
            font-size: 25px;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        }

        .navbar a:hover {
            color: #000000;
            background-color: white;
            border-radius: 10px;
        }

        /* 🔹 Main Content Layout */
        main {
            display: grid;
            grid-template-columns: auto auto;
            grid-gap: 10px;
            margin-top: 50px;
            text-align: center;
        }

        main h2 {
            color: #3e73b8;
            font-size: 30px;
        }

        main p {
            color: #334b6b;
        }

        /* 🔹 Ticket and Section Boxes */
        .ticket-section,
        .faq-section,
        .feedback-section {
            width: 60%;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: white;
            border-radius: 15px;
        }

        /* 🔹 Positioning the Ticket Sections */
        #ticket-section1 {
            margin-left: 200px;
        }

        #ticket-section2 {
            margin-right: 300px;
        }

        .faq-section {
            margin-left: 200px;
            margin-top: 20px;
        }

        .feedback-section {
            margin-right: 300px;
            margin-top: 20px;
        }

        /* 🔹 Button Styling */
        button {
            padding: 10px 20px;
            background-color: #008fcc; /* Blue Button */
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            width: 40%;
            font-size: 17px;
            margin-top: 10px;
            font-weight: bold;
        }

        button:hover {
            background-color: #0067d6; /* Darker blue on hover */
        }

        .faq-section button {
            margin-top: 10px;
        }

        /* 🔹 Image Styling */
        .image {
            width: 40%;
            float: right;
            margin-top: 20px;
            margin-left: 200px;
        }

        /* 🔹 Dashboard Description Section */
        .discription {
            margin-top: 100px;
            margin-left: 200px;
            background: #eeeeee;
            width: 80%;
            padding: 20px;
            height: fit-content;
            border-radius: 15px;
            color: white;
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

        .footer-section p,
        .footer-section ul {
            font-size: 1rem;
            line-height: 1.5;
        }

        .footer-section a {
            color: #fff;
            text-decoration: none;
        }

        .footer-section a:hover {
            text-decoration: underline;
        }

        .social-media {
            display: flex;
            gap: 10px;
        }

        .social-icon img {
            width: 24px;
            height: 24px;
            display: block;
        }

        .footer-bottom {
            text-align: center;
            padding: 10px 20px;
            background-color: #222;
        }

        .footer-bottom p {
            margin: 0;
            font-size: 0.9rem;
        }
    </style>
</head>

<body>

    <!-- 🔹 Header with Logo and Navigation Bar -->
    <header>
        <img src="images/carenet-logo.png" alt="logo" class="logo">
        <nav>
            <ul class="navbar">
                <li><a href="customerDashboard.jsp" class="active">Home</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">Feedback</a></li>
                <li><a href="#">About</a></li>
                <li><a href="CustomerDetails.jsp">Profile</a></li>
                <li><a href="Login.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>

    <!-- 🔹 Main Dashboard Content -->
    <main>
        <!-- 🔹 Create a New Ticket -->
        <section class="ticket-section" id="ticket-section1">
            <h2>Create a new ticket</h2>
            <p>Once submitted, the support team will review and respond to the ticket.</p>
            <form action="CreateTicket.jsp" method="GET">
                <button type="submit">Create</button>
            </form>
        </section>

        <!-- 🔹 View Active Tickets -->
        <section class="ticket-section" id="ticket-section2">
            <h2>Active tickets</h2>
            <p>Track progress and updates from the support team.</p>
            <button>View</button>
        </section>

        <!-- 🔹 FAQ Section -->
        <section class="faq-section">
            <h2>FAQ</h2>
            <p>Check out frequently asked questions.</p>
            <button>View FAQs</button>
        </section>

        <!-- 🔹 Feedback Section -->
        <section class="feedback-section">
            <h2>We'd love some feedback</h2>
            <p>Share your experience with our support.</p>
            <button>Rate us</button>
        </section>

        <!-- 🔹 Dashboard Description -->
        <section class="discription">
            <p>Welcome to the CareNet Support Dashboard, your one-stop solution for managing support requests.</p>
        </section>

        <!-- 🔹 Dashboard Image -->
        <img src="images/dashboard-img.png" alt="Dashboard" class="image">
    </main>

    <!-- 🔹 Footer -->
    <footer class="footer">
        <div class="footer-container">
            <div class="footer-section">
                <h3>Contact Us</h3>
                <p>Email: support@carenet.com</p>
                <p>Phone: +1 234 567 890</p>
                <p>Address: 345 Street, Suite 100, Kandy, Sri Lanka</p>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2024 CareNet. All Rights Reserved.</p>
        </div>
    </footer>

</body>
</html>
