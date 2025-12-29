<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%
	// Ensure the user is authenticated before rendering
	String user = null;
	if (session.getAttribute("user") == null) {
		response.sendRedirect(request.getContextPath() + "/login");
		return;
	} else {
		user = (String) session.getAttribute("user");
	}
	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if ("user".equals(cookie.getName())) {
				userName = cookie.getValue();
			}
			if ("JSESSIONID".equals(cookie.getName())) {
				sessionID = cookie.getValue();
			}
		}
	}
%>
<c:set var="pageTitle" value="Login Success" />
<%@ include file="/WEB-INF/jsp/fragments/header.jspf" %>

<section class="card">
	<h2 class="section-title">Welcome</h2>
	<p>Hi <strong><%= userName %></strong>, you are now logged in.</p>
	<p>Your Session ID: <code><%= sessionID %></code></p>
	<p>Session user: <strong><%= user %></strong></p>

	<div class="actions">
		<form action="${pageContext.request.contextPath}/LogoutServlet" method="post" style="display: inline;">
			<button type="submit" class="btn">Logout</button>
		</form>
	</div>
</section>

<%@ include file="/WEB-INF/jsp/fragments/footer.jspf" %>


