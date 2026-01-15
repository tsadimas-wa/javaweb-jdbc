/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.uniwa.ice.hrproject.db;

import gr.uniwa.ice.hrproject.entity.Job;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rg
 */
public class JobDAO {

    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();

        String sql = "Select job_id, job_title from jobs";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getInt("job_id"));
                job.setJobTitle(rs.getString("job_title"));
                jobs.add(job);
                System.out.println("Job " + job.getJobTitle());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("jobs" + jobs);
        return jobs;
    }

    public boolean addJob(Job job) {
        String sql = "INSERT INTO jobs (job_title) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, job.getJobTitle());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
