package gr.uniwa.ice.hrproject.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for session and cookie information
 */
public class SessionUtil {
    
    /**
     * Get all session attributes as a map
     */
    public static Map<String, Object> getSessionAttributes(HttpServletRequest request) {
        Map<String, Object> attributes = new HashMap<>();
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            Enumeration<String> attributeNames = session.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String name = attributeNames.nextElement();
                Object value = session.getAttribute(name);
                attributes.put(name, value);
            }
        }
        
        return attributes;
    }
    
    /**
     * Get all cookies as a map
     */
    public static Map<String, String> getCookies(HttpServletRequest request) {
        Map<String, String> cookies = new HashMap<>();
        Cookie[] cookieArray = request.getCookies();
        
        if (cookieArray != null) {
            for (Cookie cookie : cookieArray) {
                cookies.put(cookie.getName(), cookie.getValue());
            }
        }
        
        return cookies;
    }
    
    /**
     * Get session information
     */
    public static Map<String, Object> getSessionInfo(HttpServletRequest request) {
        Map<String, Object> info = new HashMap<>();
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            info.put("sessionId", session.getId());
            info.put("creationTime", new java.util.Date(session.getCreationTime()));
            info.put("lastAccessedTime", new java.util.Date(session.getLastAccessedTime()));
            info.put("maxInactiveInterval", session.getMaxInactiveInterval() + " seconds");
            info.put("isNew", session.isNew());
        }
        
        return info;
    }
}
