/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package gr.uniwa.ice.hrproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import gr.uniwa.ice.hrproject.entity.User;
import gr.uniwa.ice.hrproject.db.UserDAO;

/**
 *
 * @author rg
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

   private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Forward the user to the hidden JSP file
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Retrieve data from the JSP form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int jobId = Integer.parseInt(request.getParameter("jobId"));

        // 2. Create the User POJO
        User newUser = new User(username, email, password, jobId);

        // 3. Call DAO to save to database
        boolean success = userDAO.registerUser(newUser);

        // 4. Send response to user
        if (success) {
            // Redirect to a success page (or back to the form with a message)
            response.sendRedirect("list_users");
        } else {
            request.setAttribute("error", "Registration failed");
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
        }
    }

}
