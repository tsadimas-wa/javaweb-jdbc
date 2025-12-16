package gr.uniwa.ice.hrproject;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import util.DatabaseConnection;


@WebServlet("/testdb")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Database Connection Test</h1>");
            
            try (Connection conn = DatabaseConnection.getConnection()) {
                if (conn != null) {
                    out.println("<p style='color:green'>Success! Connected to PostgreSQL.</p>");
                    out.println("<p>Product: " + conn.getMetaData().getDatabaseProductName() + "</p>");
                }
            } catch (Exception e) {
                out.println("<p style='color:red'>Connection Failed: " + e.getMessage() + "</p>");
                e.printStackTrace(out);
            }
        }
    }
}