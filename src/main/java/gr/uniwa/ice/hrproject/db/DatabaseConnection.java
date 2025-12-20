/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.uniwa.ice.hrproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author rg
 */
public class DatabaseConnection {
    // Helper method to fetch variables from Tomcat Context
    private static String getContextVariable(String name) {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            return (String) envCtx.lookup(name);
        } catch (NamingException e) {
            System.err.println("Error loading JNDI variable: " + name);
            return null;
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // 1. Load Driver
        Class.forName("org.postgresql.Driver");

        // 2. Fetch Credentials from Tomcat Context
        String dbUrl = getContextVariable("DB_URL");
        String dbUser = getContextVariable("DB_USER");
        String dbPassword = getContextVariable("DB_PASSWORD");
        
        // 3. Establish Connection
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
