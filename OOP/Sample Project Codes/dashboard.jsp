<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
    🔹 This JSP page displays a table of support tickets.
    🔹 Uses JSTL (`<c:forEach>`, `<c:out>`) to loop through the ticket list and display them dynamically.
    🔹 Provides options to add, update, and delete tickets.
-->

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Ticket Dashboard</title>

    <!-- 🔹 Bootstrap for Styling -->
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
</head>

<body>

    <!-- 🔹 Main Section -->
    <main style="margin-top:2%" class="mx-5">
        <div class="row">
            <div class="container">
                <!-- Page Title -->
                <h3 class="text-start mx-2">Ticket Dashboard</h3>
            </div>

            <!-- 🔹 Add New Ticket Button -->
            <div class="text-start">
                <a href="insertresponce.jsp" class="btn btn-primary btn-sm mx-2">Add New Ticket</a>
            </div>

            <!-- 🔹 Ticket Table -->
            <table class="table mt-2">
                <thead class="table-dark">
                    <tr>
                        <th>Id</th>
                        <th>Subject</th>
                        <th>Description</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- 🔹 Loop Through Ticket List Using JSTL -->
                    <c:forEach var="tik" items="${tik}">
                        <tr>
                            <!-- Display Ticket ID -->
                            <td><c:out value="${tik.tid}" /></td>
                            
                            <!-- Display Ticket Subject -->
                            <td><c:out value="${tik.subject}" /></td>
                            
                            <!-- Display Ticket Description -->
                            <td><c:out value="${tik.description}" /></td>

                            <!-- Action Buttons (Update, Delete) -->
                            <td>
                                <!-- Update Ticket -->
                                <a href="update?id=<c:out value='${tik.tid}'/>"
                                    class="btn btn-success btn-sm">Update</a>

                                <!-- Delete Ticket -->
                                <a href="delete?id=<c:out value='${tik.tid}'/>"
                                    class="btn btn-danger btn-sm">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>

</body>

</html>
