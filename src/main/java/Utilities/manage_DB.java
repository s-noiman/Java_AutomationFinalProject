package Utilities;

import java.sql.DriverManager;

public class manage_DB extends base{

    public static void init_DB_connection(String dbURL, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, user, password);
            stmt = connection.createStatement();
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void close_DB_connection() {
        try {
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
