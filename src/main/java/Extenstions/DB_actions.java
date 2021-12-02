package Extenstions;

import Utilities.common_ops;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class DB_actions extends common_ops {

    @Step("Getting the Grafana login credentials from the DB.")
    public static List<String> get_login_credentials(int user_id) {
        List<String> credentials = new ArrayList<>();
        try
        {
            rs = stmt.executeQuery("SELECT user,password FROM test WHERE id='" + user_id + "'");
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
        return credentials;
    }

    @Step("Getting user details from the DB.")
    public static List<String> get_user_contact_details(int user_id) {
        List<String> contactDetails = new ArrayList<>();
        try
        {
            rs = stmt.executeQuery("SELECT user,email FROM test WHERE id='" + user_id + "'");
            rs.next();
            contactDetails.add(rs.getString(1));
            contactDetails.add(rs.getString(3));
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
        return contactDetails;
    }

}
