package org.webscrappe.france.travail.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.webscrappe.france.travail.model.JobListing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobListingLocalHtmlParser {

    public List<JobListing> parseHtmlFile(String filePath) throws IOException {
        File input = new File(filePath);
        Document doc = Jsoup.parse(input, "UTF-8");

        List<JobListing> jobListings = new ArrayList<>();

        Elements listItems = doc.select("li[data-id-offre]");
        for (Element listItem : listItems) {
            JobListing jobListing = new JobListing();
            jobListing.setDataIdOffre(listItem.attr("data-id-offre"));
            Element link = listItem.selectFirst("a.media.with-fav");
            jobListing.setHref("https://candidat.francetravail.fr" + link.attr("href"));
            jobListing.setTitle(link.selectFirst("span.media-heading-title").text());
            jobListing.setSubtext(link.selectFirst("p.subtext").text());
            jobListing.setDescription(link.selectFirst("p.description").text());
            jobListing.setContract(link.selectFirst("p.contrat.visible-xs").text());
            jobListing.setDate(link.selectFirst("p.date").text());

            jobListings.add(jobListing);
        }

        return jobListings;
    }

    public void printJobListings(List<JobListing> jobListings) {
        for (JobListing jobListing : jobListings) {
            System.out.println(jobListing);
        }
        System.out.println("Total job listings: " + jobListings.size());
    }

    public static void main(String[] args) throws IOException {
        JobListingLocalHtmlParser parser = new JobListingLocalHtmlParser();
        List<JobListing> jobListings = parser.parseHtmlFile("src/main/java/org/webscrappe/france/travail/joblistingsdata/index.html");
        parser.printJobListings(jobListings);
    }
}