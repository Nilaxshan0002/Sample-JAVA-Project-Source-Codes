<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
    🔹 This JSP page allows users to update a response related to a specific ticket.
    🔹 It uses JSTL (`<c:out>`) to safely display values from the `response` object.
    🔹 The form submits data to the `updateResponseAction` servlet for processing.
-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Response</title>

    <!-- 🔹 Bootstrap CSS for styling -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
          crossorigin="anonymous">
</head>
<body>

    <!-- 🔹 Header Section -->
    <header class="navbar navbar-dark bg-primary">
        <div>
            <!-- 🔹 Navigation link to go back to the response list page -->
            <a href="responce.jsp" class="navbar-brand mx-2 text-warning">Back to Responses</a>
        </div>
    </header>

    <!-- 🔹 Main Content Section -->
    <main style="margin-top:2%" class="mx-5">
        <div class="col-6 mx-auto">
        
            <!-- 🔹 Form for updating response -->
            <form action="updateResponseAction" method="post">
                <h2>Update Response</h2>
                
                <!-- 🔹 Hidden input field to store ticket ID (tid) -->
                <input type="hidden" name="tid" value="<c:out value='${response.tid}'/>" />
                
                <!-- 🔹 Textarea for updating response text -->
                <div class="form-group mb-2 row">
                    <label class="col-sm-2 col-form-label">Response Text</label>
                    <textarea name="responseText" class="form-control border-primary" rows="4" required>
                        <c:out value='${response.responseText}'/>
                    </textarea>
                </div>
                
                <!-- 🔹 Submit button to update response -->
                <div class="form-group mb-2 row">
                    <input type="submit" class="btn btn-warning" value="Update Response">
                </div>
            </form>
        </div>
    </main>

</body>
</html>
