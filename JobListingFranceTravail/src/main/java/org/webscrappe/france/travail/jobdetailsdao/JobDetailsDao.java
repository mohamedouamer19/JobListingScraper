package org.webscrappe.france.travail.jobdetailsdao;

import org.webscrappe.france.travail.model.JobDetails;
import org.webscrappe.france.travail.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobDetailsDao {

    public void createJobDetails(JobDetails jobDetails) {
        String sql = "INSERT INTO job_details (offer_number, title, location, posted_date, description, contract_type, work_hours, salary, company_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, jobDetails.getOfferNumber());
            statement.setString(2, jobDetails.getTitle());
            statement.setString(3, jobDetails.getLocation());
            statement.setString(4, jobDetails.getPostedDate());
            statement.setString(5, jobDetails.getDescription());
            statement.setString(6, jobDetails.getContractType());
            statement.setString(7, jobDetails.getWorkHours());
            statement.setString(8, jobDetails.getSalary());
            statement.setString(9, jobDetails.getCompanyName());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<JobDetails> readAllJobDetails() {
        List<JobDetails> jobDetailsList = new ArrayList<>();
        String sql = "SELECT * FROM job_details";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                JobDetails jobDetails = new JobDetails();
                jobDetails.setOfferNumber(resultSet.getString("offer_number"));
                jobDetails.setTitle(resultSet.getString("title"));
                jobDetails.setLocation(resultSet.getString("location"));
                jobDetails.setPostedDate(resultSet.getString("posted_date"));
                jobDetails.setDescription(resultSet.getString("description"));
                jobDetails.setContractType(resultSet.getString("contract_type"));
                jobDetails.setWorkHours(resultSet.getString("work_hours"));
                jobDetails.setSalary(resultSet.getString("salary"));
                jobDetails.setCompanyName(resultSet.getString("company_name"));

                jobDetailsList.add(jobDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobDetailsList;
    }

    public void updateJobDetails(JobDetails jobDetails) {
        String sql = "UPDATE job_details SET offer_number = ?, title = ?, location = ?, posted_date = ?, description = ?, contract_type = ?, work_hours = ?, salary = ?, company_name = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, jobDetails.getOfferNumber());
            statement.setString(2, jobDetails.getTitle());
            statement.setString(3, jobDetails.getLocation());
            statement.setString(4, jobDetails.getPostedDate());
            statement.setString(5, jobDetails.getDescription());
            statement.setString(6, jobDetails.getContractType());
            statement.setString(7, jobDetails.getWorkHours());
            statement.setString(8, jobDetails.getSalary());
            statement.setString(9, jobDetails.getCompanyName());
            statement.setInt(10, jobDetails.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJobDetails(int id) {
        String sql = "DELETE FROM job_details WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}