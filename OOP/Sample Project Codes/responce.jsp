<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  
    🔹 This JSP page displays responses for support tickets.
    🔹 It retrieves response data from the request attribute `responses` and dynamically generates a table.
    🔹 Uses JSTL `<c:forEach>` to loop through response records and display them.
-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Responses</title>

    <!-- 🔹 Importing Bootstrap for styling -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
          crossorigin="anonymous">
</head>

<body>
    
    <!-- 🔹 Navigation Header -->
    <header class="navbar navbar-dark bg-primary">
        <div>
            <a href="dashboard" class="navbar-brand mx-2 text-warning">Back to Dashboard</a>
        </div>
    </header>

    <!-- 🔹 Main Content Section -->
    <main style="margin-top:2%" class="mx-5">
        
        <!-- 🔹 Title Section -->
        <div class="container">
            <h3 class="text-start mx-2">Responses</h3>
        </div>
        
        <!-- 🔹 Table to Display Responses -->
        <table class="table mt-2">
            <thead class="table-dark">
                <tr>
                    <th>Ticket ID</th>  <!-- Ticket identifier -->
                    <th>Response Text</th>  <!-- The response message -->
                    <th>Action</th>  <!-- Update button to modify response -->
                </tr>
            </thead>
            <tbody>
                <!-- 🔹 Loop through `responses` list and populate table rows -->
                <c:forEach var="resp" items="${responses}">
                    <tr>
                        <!-- Display Ticket ID -->
                        <td><c:out value="${resp.tid}"></c:out></td>
                        
                        <!-- Display Response Text -->
                        <td><c:out value="${resp.responseText}"></c:out></td>
                        
                        <!-- Action Button to Update Response -->
                        <td>
                            <a href="updateResponse?tid=<c:out value='${resp.tid}'/>" 
                               class="btn btn-warning btn-sm">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </main>
    
</body>
</html>
