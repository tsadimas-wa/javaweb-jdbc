/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package gr.uniwa.ice.hrproject;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import util.User;
import util.UserDAO;

@WebServlet("/list_users")
public class ListUsersServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Get the list of users from DB
        List<User> list = userDAO.getAllUsers();
        System.out.println("list " + list);
        
        // 2. Attach the list to the request object so JSP can see it
        request.setAttribute("userList", list);
        
        // 3. Forward the request to the JSP page
        request.getRequestDispatcher("/WEB-INF/jsp/list_users.jsp").forward(request, response);    }
}
