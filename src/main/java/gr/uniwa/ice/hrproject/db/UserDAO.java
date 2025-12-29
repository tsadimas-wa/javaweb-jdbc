/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.uniwa.ice.hrproject.db;

import gr.uniwa.ice.hrproject.db.DatabaseConnection;
import gr.uniwa.ice.hrproject.entity.User;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rg
 */
public class UserDAO {

    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, email, password, job_id) VALUES (?, ?, crypt(?, gen_salt('bf')), ?)";

        // Try-with-resources ensures connection closes automatically
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getJobId());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            System.err.println("Registration error: " + e.getMessage());
            return false;
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        // SQL Join to get User details + Job Title
        String sql = "SELECT u.user_id, u.username, u.email, j.job_title "
                + "FROM users u "
                + "JOIN jobs j ON u.job_id = j.job_id "
                + "ORDER BY u.user_id ASC";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setJobTitle(rs.getString("job_title")); // Populating the new field
                System.out.println("user " + user);
                userList.add(user);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return userList;
    }

    public User login(String username, String password) throws SQLException {
        String sql = "SELECT user_id, username, email FROM users WHERE username = ? AND password = crypt(?, password) LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs != null && rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
//                user.setJobTitle(rs.getString("job_title"));
                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
}
