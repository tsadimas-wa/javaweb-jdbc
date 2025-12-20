<%-- 
    Document   : register
    Created on : Dec 16, 2025, 10:03:19 AM
    Author     : rg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Register User</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
    <h2 style="text-align:center">Create New User</h2>
    
    <form action="register" method="post">
        <label>Username:</label>
        <input type="text" name="username" required>
        
        <label>Email:</label>
        <input type="email" name="email" required>
        
        <label>Select Job:</label>
        <select name="jobId">
            <option value="1">Software Engineer</option>
            <option value="2">HR Manager</option>
            <option value="3">Sales Rep</option>
        </select>

        <button type="submit">Save User</button>
    </form>
</body>
</html>
