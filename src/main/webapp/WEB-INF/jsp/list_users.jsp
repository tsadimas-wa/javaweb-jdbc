<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %> <!DOCTYPE html>
<html>
<head>
    <title>All Users</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
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
        <a href="register" class="btn">Add New User</a>
    </div>
</body>
</html>
