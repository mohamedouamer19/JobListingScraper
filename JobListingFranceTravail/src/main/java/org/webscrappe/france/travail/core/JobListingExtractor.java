package org.webscrappe.france.travail.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.webscrappe.france.travail.model.JobListing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JobListingExtractor {
    private String urlString;

    public JobListingExtractor(String urlString) {
        this.urlString = urlString;
    }

    public void extractJobListings() throws IOException {
        URL url = new URL(this.urlString);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36");

        if (conn.getResponseCode() != 200) {
            System.out.println("Error: HTTP request failed with code " + conn.getResponseCode());
            return;
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

            System.out.println(jobListing);
        }
    }
    public static void main(String[] args) throws IOException {
        String urlString = "https://candidat.francetravail.fr/offres/recherche?motsCles=java&offresPartenaires=true&rayon=10&tri=0";
        JobListingExtractor extractor = new JobListingExtractor(urlString);
        extractor.extractJobListings();
    }
}