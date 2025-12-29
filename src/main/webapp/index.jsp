<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<c:set var="pageTitle" value="Home" />
<%@ include file="/WEB-INF/jsp/fragments/header.jspf" %>

<c:if test="${not empty sessionScope.user}">
    <section class="card" style="max-width: 800px; margin: 20px auto; text-align:center;">
        <c:choose>
            <c:when test="${not empty sessionScope.user.jobTitle}">
                <h2 class="section-title">${sessionScope.user.jobTitle}</h2>
            </c:when>
            <c:otherwise>
                <h2 class="section-title">No job title available</h2>
            </c:otherwise>
        </c:choose>
    </section>
</c:if>

<%@ include file="/WEB-INF/jsp/fragments/footer.jspf" %>
