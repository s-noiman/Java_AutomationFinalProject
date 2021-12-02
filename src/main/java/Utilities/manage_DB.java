package Utilities;

import io.qameta.allure.Step;

import java.sql.DriverManager;

public class manage_DB extends base {

    @Step("Initialization DB connection.")
    public static void init_DB_connection(String dbURL, String user, String password) {
        try {
            Class.forName(manage_DDT.get_data("ClassName"));
            connection = DriverManager.getConnection(dbURL, user, password);
            stmt = connection.createStatement();
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Step("Close DB connection.")
    public static void close_DB_connection() {
        try {
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
