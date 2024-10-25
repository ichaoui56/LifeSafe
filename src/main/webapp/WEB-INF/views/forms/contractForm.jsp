<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 25/10/2024
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Contract</title>
</head>
<body>
<h2>Add Contract</h2>
<form action="${pageContext.request.contextPath}/contract/add?devisId=${devisId}" method="post" enctype="multipart/form-data">
    <!-- Hidden field to pass the Devis ID -->
    <input type="hidden" name="devisId" value="${devisId}">

    <!-- Document upload field -->
    <label for="document">Justification Document:</label>
    <input type="file" id="document" name="document" accept=".pdf,.jpg,.jpeg,.png" required>
    <br><br>

    <button type="submit">Submit Contract</button>
</form>

<!-- Cancel Button -->
<a href="${pageContext.request.contextPath}/devis">Cancel</a>
</body>
</html>
