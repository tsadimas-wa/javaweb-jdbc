<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<c:set var="pageTitle" value="Register User" />
<%@ include file="/WEB-INF/jsp/fragments/header.jspf" %>

<section class="form-card">
    <h2 class="section-title">Create New User</h2>

    <form action="register" method="post" class="form-grid">
        <label>Username:</label>
        <input type="text" name="username" required>
        
        <label>Email:</label>
        <input type="email" name="email" required>
        
        <label>Password:</label>
        <input type="password" name="password" required>
        
        <label>Select Job:</label>
        <select name="jobId">
            <option value="1">Software Engineer</option>
            <option value="2">HR Manager</option>
            <option value="3">Sales Rep</option>
        </select>

        <button type="submit" class="btn">Save User</button>
    </form>
</section>

<%@ include file="/WEB-INF/jsp/fragments/footer.jspf" %>
