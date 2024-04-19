package org.webscrappe.france.travail.joblistingdao;
import org.webscrappe.france.travail.model.JobListing;
import org.webscrappe.france.travail.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobListingDao {

    public void createJobListing(JobListing jobListing) {
        String sql = "INSERT INTO job_listings (data_id_offre, href, title, subtext, description, contract, date) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, jobListing.getDataIdOffre());
            statement.setString(2, jobListing.getHref());
            statement.setString(3, jobListing.getTitle());
            statement.setString(4, jobListing.getSubtext());
            statement.setString(5, jobListing.getDescription());
            statement.setString(6, jobListing.getContract());
            statement.setString(7, jobListing.getDate());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<JobListing> readAllJobListings() {
        List<JobListing> jobListings = new ArrayList<>();
        String sql = "SELECT * FROM job_listings";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                JobListing jobListing = new JobListing();
                jobListing.setId(resultSet.getInt("id"));
                jobListing.setDataIdOffre(resultSet.getString("data_id_offre"));
                jobListing.setHref(resultSet.getString("href"));
                jobListing.setTitle(resultSet.getString("title"));
                jobListing.setSubtext(resultSet.getString("subtext"));
                jobListing.setDescription(resultSet.getString("description"));
                jobListing.setContract(resultSet.getString("contract"));
                jobListing.setDate(resultSet.getString("date"));

                jobListings.add(jobListing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobListings;
    }

    public void updateJobListing(JobListing jobListing) {
        String sql = "UPDATE job_listings SET data_id_offre = ?, href = ?, title = ?, subtext = ?, description = ?, contract = ?, date = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, jobListing.getDataIdOffre());
            statement.setString(2, jobListing.getHref());
            statement.setString(3, jobListing.getTitle());
            statement.setString(4, jobListing.getSubtext());
            statement.setString(5, jobListing.getDescription());
            statement.setString(6, jobListing.getContract());
            statement.setString(7, jobListing.getDate());
            statement.setInt(8, jobListing.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJobListing(int id) {
        String sql = "DELETE FROM job_listings WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}