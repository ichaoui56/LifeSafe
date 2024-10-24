<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>Register</h2>

<c:if test="${not empty error}">
    <div style="color: red;">${error}</div>
</c:if>

<form action="${pageContext.request.contextPath}/auth/register" method="post">
    <label>Name:</label><br>
    <input type="text" name="name" required><br><br>

    <label>Address:</label><br>
    <input type="text" name="address"><br><br>

    <label>Phone:</label><br>
    <input type="text" name="phone"><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <input type="submit" value="Register">
</form>

</body>
</html>
