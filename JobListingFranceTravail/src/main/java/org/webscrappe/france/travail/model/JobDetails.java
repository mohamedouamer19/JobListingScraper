package org.webscrappe.france.travail.model;

public class JobDetails {
    private int id;
    private String offerNumber;
    private String title;
    private String location;
    private String postedDate;
    private String description;
    private String contractType;
    private String workHours;
    private String salary;
    private String companyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfferNumber() {
        return offerNumber;
    }

    public void setOfferNumber(String offerNumber) {
        this.offerNumber = offerNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        if (workHours == null) {
            workHours = "Not Specified";
        }
        this.workHours = workHours;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        if (salary == null) {
            salary = "Not Specified";
        }
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (companyName == null) {
            companyName = "Not Specified";
        }
        this.companyName = companyName;
    }


    @Override
    public String toString() {
        return "JobDetails:\n" +
                "Offer Number: " + offerNumber + "\n" +
                "Title: " + title + "\n" +
                "Location: " + location + "\n" +
                "Posted Date: " + postedDate + "\n" +
                "Description: " + description + "\n" +
                "Contract Type: " + contractType + "\n" +
                "Work Hours: " + workHours + "\n" +
                "Salary: " + salary + "\n" +
                "Company Name: " + companyName + "\n";
    }

}