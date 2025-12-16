/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author rg
 */
public class UserDAO {
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, email, job_id) VALUES (?, ?, ?)";
        
        // Try-with-resources ensures connection closes automatically
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getJobId());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            return false;
        }
    }
    
}
