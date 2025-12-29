package gr.uniwa.ice.hrproject.filter;

import gr.uniwa.ice.hrproject.entity.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Authentication filter to protect pages from unauthorized access
 * Configured in web.xml
 */
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Get the session, but don't create a new one if it doesn't exist
        HttpSession session = httpRequest.getSession(false);
        
        // Check if user is logged in
        User user = null;
        if (session != null) {
            user = (User) session.getAttribute("user");
        }
        
        boolean isLoggedIn = (user != null);
        
        // Get the requested URI for debugging
        String requestURI = httpRequest.getRequestURI();
        System.out.println("AuthenticationFilter - URI: " + requestURI + ", Logged in: " + isLoggedIn);
        
        if (isLoggedIn) {
            // User is logged in, allow the request to proceed
            chain.doFilter(request, response);
        } else {
            // User is not logged in, redirect to login page
            System.out.println("User not authenticated, redirecting to login");
            String contextPath = httpRequest.getContextPath();
            httpResponse.sendRedirect(contextPath + "/login");
        }
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}
