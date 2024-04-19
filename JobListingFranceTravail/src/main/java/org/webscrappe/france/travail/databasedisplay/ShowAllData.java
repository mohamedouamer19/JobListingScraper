package org.webscrappe.france.travail.databasedisplay;

import org.webscrappe.france.travail.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowAllData {
    public void displayAllData() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                String selectAllSql = "SELECT * FROM job_listings";
                try (Statement statement = connection.createStatement()) {
                    ResultSet resultSet = statement.executeQuery(selectAllSql);
                    while (resultSet.next()) {
                        System.out.println("ID: " + resultSet.getInt("id"));
                        System.out.println("Data ID Offer: " + resultSet.getString("data_id_offre"));
                        System.out.println("Href: " + resultSet.getString("href"));
                        System.out.println("Title: " + resultSet.getString("title"));
                        System.out.println("Subtext: " + resultSet.getString("subtext"));
                        System.out.println("Description: " + resultSet.getString("description"));
                        System.out.println("Contract: " + resultSet.getString("contract"));
                        System.out.println("Date: " + resultSet.getString("date"));
                        System.out.println("-----------------------------");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ShowAllData showAllData = new ShowAllData();
        showAllData.displayAllData();
    }
}