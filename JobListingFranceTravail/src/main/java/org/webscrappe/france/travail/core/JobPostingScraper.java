package org.webscrappe.france.travail.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.webscrappe.france.travail.model.JobDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JobPostingScraper {
    public JobDetails scrapeJobDetails(String urlString) throws IOException {
        URL url = new URL(urlString);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36");

        if (conn.getResponseCode() != 200) {
            System.out.println("Error: HTTP request failed with code " + conn.getResponseCode());
            return null;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder htmlContent = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            htmlContent.append(inputLine);
        }
        in.close();
        conn.disconnect();

        Document doc = Jsoup.parse(htmlContent.toString());

        Element div = doc.selectFirst("div[itemtype=http://schema.org/JobPosting]");
        JobDetails jobDetails = new JobDetails();

        Element offerNumberElement = div.selectFirst("span[itemprop=value]");
        if (offerNumberElement != null) {
            jobDetails.setOfferNumber(offerNumberElement.text());
        }

        Element titleElement = div.selectFirst("span[itemprop=title]");
        if (titleElement != null) {
            jobDetails.setTitle(titleElement.text());
        }

        Element locationElement = div.selectFirst("span[itemprop=name]");
        if (locationElement != null) {
            jobDetails.setLocation(locationElement.text());
        }

        Element postedDateElement = div.selectFirst("span[itemprop=datePosted]");
        if (postedDateElement != null) {
            jobDetails.setPostedDate(postedDateElement.text());
        }

        Element descriptionElement = div.selectFirst("div[itemprop=description]");
        if (descriptionElement != null) {
            jobDetails.setDescription(descriptionElement.text());
        }

        Element contractTypeElement = div.selectFirst("dd");
        if (contractTypeElement != null) {
            jobDetails.setContractType(contractTypeElement.text());
        }

        Element workHoursElement = div.selectFirst("dd[itemprop=workHours]");
        if (workHoursElement != null) {
            jobDetails.setWorkHours(workHoursElement.text());
        }

        Element minValueElement = div.selectFirst("span[itemprop=minValue]");
        Element maxValueElement = div.selectFirst("span[itemprop=maxValue]");
        if (minValueElement != null && maxValueElement != null) {
            jobDetails.setSalary(minValueElement.text() + " - " + maxValueElement.text());
        }

        Element companyNameElement = div.selectFirst("h3.t4.title");
        if (companyNameElement != null) {
            jobDetails.setCompanyName(companyNameElement.text());
        }

        return jobDetails;
    }
}