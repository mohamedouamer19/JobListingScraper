package org.webscrappe.france.travail.model;

public class JobListing {
    private int id;
    private String dataIdOffre;
    private String href;
    private String title;
    private String subtext;
    private String description;
    private String contract;
    private String date;

    // getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataIdOffre() {
        return dataIdOffre;
    }

    public void setDataIdOffre(String dataIdOffre) {
        this.dataIdOffre = dataIdOffre;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JobListing:\n" +
                "Data ID Offre: " + dataIdOffre + "\n" +
                "Href: " + href + "\n" +
                "Title: " + title + "\n" +
                "Subtext: " + subtext + "\n" +
                "Description: " + description + "\n" +
                "Contract: " + contract + "\n" +
                "Date: " + date + "\n";
    }
}