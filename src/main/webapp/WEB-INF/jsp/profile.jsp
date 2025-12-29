<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<c:set var="pageTitle" value="User Profile" />
<%@ include file="/WEB-INF/jsp/fragments/header.jspf" %>

<section class="profile-container">
    <h2 class="profile-header">User Profile</h2>
    
    <c:choose>
        <c:when test="${not empty user}">
            <div class="profile-info">
                <div class="profile-field">
                    <span class="profile-label">User ID:</span>
                    <span class="profile-value">${user.userId}</span>
                </div>
                <div class="profile-field">
                    <span class="profile-label">Username:</span>
                    <span class="profile-value">${user.username}</span>
                </div>
                <div class="profile-field">
                    <span class="profile-label">Email:</span>
                    <span class="profile-value">${user.email}</span>
                </div>
                <div class="profile-field">
                    <span class="profile-label">Job Title:</span>
                    <span class="profile-value">${user.jobTitle}</span>
                </div>
                <div class="profile-field">
                    <span class="profile-label">Job ID:</span>
                    <span class="profile-value">${user.jobId}</span>
                </div>
            </div>
            
            <div class="profile-actions">
                <a href="${pageContext.request.contextPath}/list_users" class="btn">View All Users</a>
                <form action="${pageContext.request.contextPath}/LogoutServlet" method="post" style="display: inline;">
                    <button type="submit" class="btn">Logout</button>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <p style="text-align: center; color: #999;">No user information available.</p>
            <div class="profile-actions">
                <a href="${pageContext.request.contextPath}/login" class="btn">Login</a>
            </div>
        </c:otherwise>
    </c:choose>
</section>

<%@ include file="/WEB-INF/jsp/fragments/footer.jspf" %>
