package org.webscrappe.france.travail;

import org.webscrappe.france.travail.core.JobListingLocalHtmlParser;
import org.webscrappe.france.travail.core.JobPostingScraper;
import org.webscrappe.france.travail.saver.JobDetailsSaver;
import org.webscrappe.france.travail.model.JobDetails;
import org.webscrappe.france.travail.model.JobListing;

import java.io.IOException;
import java.util.List;

public class Main {

    private JobListingLocalHtmlParser parser;
    private JobDetailsSaver jobDetailsSaver;
    private JobPostingScraper jobPostingScraper;

    public Main() {
        this.parser = new JobListingLocalHtmlParser();
        this.jobDetailsSaver = new JobDetailsSaver();
        this.jobPostingScraper = new JobPostingScraper();
    }

    public void run() {
        List<JobListing> jobListings = getJobListings();
        saveJobDetails(jobListings);
    }

    private List<JobListing> getJobListings() {
        try {
            return parser.parseHtmlFile("src/main/java/org/webscrappe/france/travail/joblistingsdata/index.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveJobDetails(List<JobListing> jobListings) {
        for (JobListing jobListing : jobListings) {
            try {
                JobDetails jobDetails = jobPostingScraper.scrapeJobDetails(jobListing.getHref());
                if (jobDetails.getLocation().toLowerCase().contains("lyon")){
                    System.out.println("Href: " + jobListing.getHref() + "\n" );
                    System.out.println(jobDetails);
                    //jobDetailsSaver.saveJobDetailsToJson(List.of(jobDetails));
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}