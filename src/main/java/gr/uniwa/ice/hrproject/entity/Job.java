package gr.uniwa.ice.hrproject.entity;

import java.io.Serializable;

public class Job implements Serializable {
    private int jobId;
    private String jobTitle;

    public Job() {} // Default constructor

    public Job(int jobId, String jobTitle) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
    }

    // Getters and Setters
    public int getJobId() { return jobId; }
    public void setJobId(int jobId) { this.jobId = jobId; }
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    
}
