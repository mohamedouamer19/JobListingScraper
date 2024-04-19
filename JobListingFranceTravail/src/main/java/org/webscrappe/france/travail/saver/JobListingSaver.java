package org.webscrappe.france.travail.saver;


import org.webscrappe.france.travail.model.JobListing;
import org.webscrappe.france.travail.joblistingdao.JobListingDao;
import java.util.List;

public class JobListingSaver {

    public void saveJobListings(List<JobListing> jobListings) {
        JobListingDao jobListingDao = new JobListingDao();
        for (JobListing jobListing : jobListings) {
            jobListingDao.createJobListing(jobListing);
        }
    }

}