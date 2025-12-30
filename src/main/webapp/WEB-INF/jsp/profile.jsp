<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="gr.uniwa.ice.hrproject.util.SessionUtil" %>
<%@ page import="java.util.Map" %>
<c:set var="pageTitle" value="User Profile" />
<%@ include file="/WEB-INF/jsp/fragments/header.jspf" %>

<%
    // Get session and cookie information
    Map<String, Object> sessionAttributes = SessionUtil.getSessionAttributes(request);
    Map<String, String> cookies = SessionUtil.getCookies(request);
    Map<String, Object> sessionInfo = SessionUtil.getSessionInfo(request);
    
    request.setAttribute("sessionAttributes", sessionAttributes);
    request.setAttribute("cookies", cookies);
    request.setAttribute("sessionInfo", sessionInfo);
%>

<section class="profile-container">
    <h2 class="profile-header">User Profile</h2>
    
    <c:choose>
        <c:when test="${not empty user}">
            <div class="profile-info">
                <h3>User Information</h3>
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
            
            <!-- Session Information Section -->
            <div class="profile-info">
                <h3>Session Information</h3>
                <c:if test="${not empty sessionInfo}">
                    <c:forEach var="entry" items="${sessionInfo}">
                        <div class="profile-field">
                            <span class="profile-label"><c:out value="${entry.key}"/>:</span>
                            <span class="profile-value"><c:out value="${entry.value}"/></span>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
            
            <!-- Session Attributes Section -->
            <div class="profile-info">
                <h3>Session Attributes</h3>
                <c:choose>
                    <c:when test="${not empty sessionAttributes}">
                        <table class="info-table">
                            <thead>
                                <tr>
                                    <th>Attribute Name</th>
                                    <th>Value</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="entry" items="${sessionAttributes}">
                                    <tr>
                                        <td><strong><c:out value="${entry.key}"/></strong></td>
                                        <td><c:out value="${entry.value}"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p style="color: #999;">No session attributes found.</p>
                    </c:otherwise>
                </c:choose>
            </div>
            
            <!-- Cookies Section -->
            <div class="profile-info">
                <h3>Cookies</h3>
                <c:choose>
                    <c:when test="${not empty cookies}">
                        <table class="info-table">
                            <thead>
                                <tr>
                                    <th>Cookie Name</th>
                                    <th>Cookie Value</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="entry" items="${cookies}">
                                    <tr>
                                        <td><strong><c:out value="${entry.key}"/></strong></td>
                                        <td><c:out value="${entry.value}"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p style="color: #999;">No cookies found.</p>
                    </c:otherwise>
                </c:choose>
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
