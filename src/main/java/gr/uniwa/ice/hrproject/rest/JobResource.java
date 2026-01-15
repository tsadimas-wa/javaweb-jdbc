/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.uniwa.ice.hrproject.rest;

import gr.uniwa.ice.hrproject.db.JobDAO;
import gr.uniwa.ice.hrproject.entity.Job;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/jobs")
public class JobResource {

    
    private JobDAO jobDAO;
    
    
    public JobResource() {
        this.jobDAO = new JobDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getJobs() {
        
        List<Job> jobs= jobDAO.getAllJobs();
        System.out.println("jobs " + jobs.size());
        // Το Jersey θα χρησιμοποιήσει τον Jackson για να μετατρέψει τη List σε JSON Array
        return Response.ok(jobs).build(); 
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addJob(Job job) {
        boolean success = jobDAO.addJob(job);
        if (success) {
            return Response.status(Response.Status.CREATED).entity(job).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Could not create job").build();
    }
}