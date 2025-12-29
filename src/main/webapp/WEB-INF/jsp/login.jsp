<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<c:set var="pageTitle" value="Login" />
<%@ include file="/WEB-INF/jsp/fragments/header.jspf" %>

<section class="form-card">
    <h2 class="section-title">Login</h2>

    <form action="login" method="post" class="form-grid">
        <label>Username:</label>
        <input type="text" name="username" required>
        
        <label>Password:</label>
        <input type="password" name="password" required>
        
        <button type="submit" class="btn">Login</button>
    </form>
    
    <div class="form-note">
        <p>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register here</a></p>
    </div>
</section>

<%@ include file="/WEB-INF/jsp/fragments/footer.jspf" %>
