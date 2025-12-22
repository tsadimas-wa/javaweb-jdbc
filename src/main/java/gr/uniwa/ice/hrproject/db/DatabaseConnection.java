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
        Class.forName("org.sqlite.JDBC");

        // Βρίσκουμε τον φάκελο του χρήστη (π.χ. C:\Users\Giannis ή /home/giannis)
        String userHome = System.getProperty("user.home");

        // Φτιάχνουμε το Path δυναμικά
        // Η βάση θα αποθηκευτεί στο C:\Users\Giannis\hr_project.db
        String dbUrl = "jdbc:sqlite:" + userHome + "/hr_project.db";

        return DriverManager.getConnection(dbUrl);
    }
}
