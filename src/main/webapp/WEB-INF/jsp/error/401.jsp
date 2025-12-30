<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>401 - Unauthorized</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .error-container {
            text-align: center;
            padding: 50px;
            max-width: 600px;
            margin: 100px auto;
        }
        .error-code {
            font-size: 72px;
            font-weight: bold;
            color: #e74c3c;
            margin-bottom: 20px;
        }
        .error-message {
            font-size: 24px;
            color: #555;
            margin-bottom: 20px;
        }
        .error-description {
            font-size: 16px;
            color: #777;
            margin-bottom: 30px;
        }
        .home-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin: 5px;
        }
        .home-link:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-code">401</div>
        <div class="error-message">Unauthorized</div>
        <div class="error-description">
            You need to be logged in to access this resource. Please log in to continue.
        </div>
        <a href="${pageContext.request.contextPath}/login" class="home-link">Go to Login</a>
        <a href="${pageContext.request.contextPath}/" class="home-link">Go to Home</a>
    </div>
</body>
</html>
