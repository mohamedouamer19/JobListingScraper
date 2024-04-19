package org.webscrappe.france.travail.database;

public class DatabaseManager {

    public static void main(String[] args) {
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        databaseInitializer.initializeDatabase();
    }
}