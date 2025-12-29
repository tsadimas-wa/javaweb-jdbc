<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<c:set var="pageTitle" value="All Users" />
<%@ include file="/WEB-INF/jsp/fragments/header.jspf" %>

<section class="table-card">
    <h2 class="section-title">Registered Employees</h2>

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

    <div class="actions">
        <a href="${pageContext.request.contextPath}/register" class="btn">Add New User</a>
    </div>
</section>

<%@ include file="/WEB-INF/jsp/fragments/footer.jspf" %>
