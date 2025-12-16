<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %> <!DOCTYPE html>
<html>
<head>
    <title>All Users</title>
    <style>
        table { width: 80%; margin: 20px auto; border-collapse: collapse; font-family: sans-serif; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f2f2f2; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        .btn { display: inline-block; margin: 20px; text-decoration: none; padding: 10px 20px; background: #007bff; color: white; border-radius: 5px; }
    </style>
</head>
<body>
    <h2 style="text-align:center">Registered Employees</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Job Title</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.jobTitle}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div style="text-align: center;">
        <a href="register.jsp" class="btn">Add New User</a>
    </div>
</body>
</html>
