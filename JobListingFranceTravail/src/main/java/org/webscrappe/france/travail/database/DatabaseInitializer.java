package org.webscrappe.france.travail.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                createJobListingsTable(connection);
                createJobDetailsTable(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createJobListingsTable(Connection connection) throws SQLException {
        String createJobListingsTableSql = "CREATE TABLE IF NOT EXISTS job_listings (" +
                "id INT AUTO_INCREMENT," +
                "data_id_offre VARCHAR(255) NOT NULL," +
                "href VARCHAR(255) NOT NULL," +
                "title VARCHAR(255) NOT NULL," +
                "subtext TEXT," +
                "description TEXT," +
                "contract VARCHAR(255)," +
                "date VARCHAR(255)," +
                "PRIMARY KEY (id)" +
                ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createJobListingsTableSql);
        }
    }

    private void createJobDetailsTable(Connection connection) throws SQLException {
        String createJobDetailsTableSql = "CREATE TABLE IF NOT EXISTS job_details (" +
                "id INT AUTO_INCREMENT," +
                "offer_number VARCHAR(255) NOT NULL," +
                "title VARCHAR(255) NOT NULL," +
                "location VARCHAR(255)," +
                "posted_date VARCHAR(255)," +
                "description TEXT," +
                "contract_type VARCHAR(255)," +
                "work_hours VARCHAR(255)," +
                "salary VARCHAR(255)," +
                "company_name VARCHAR(255)," +
                "PRIMARY KEY (id)" +
                ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createJobDetailsTableSql);
        }
    }


}