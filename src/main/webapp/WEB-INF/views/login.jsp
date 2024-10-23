<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
</head>
<body>
<h2>Login</h2>

<c:if test="${not empty error}">
    <div style="color: red;">${error}</div>
</c:if>

<form action="${pageContext.request.contextPath}/user/login" method="post">
    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>

</body>
</html>
