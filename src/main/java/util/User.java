package util;

import java.io.Serializable;


public class User implements Serializable {
    private int userId;
    private String username;
    private String email;
    private int jobId; // Foreign Key ID

    public User() {}

    public User(String username, String email, int jobId) {
        this.username = username;
        this.email = email;
        this.jobId = jobId;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }
    
}
