package Extenstions;

import Utilities.common_ops;
import Utilities.manage_DDT;
import io.qameta.allure.Step;
import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.List;

public class DB_actions extends common_ops {

    @Step("Getting the Grafana login credentials from the DB.")
    public static List<String> get_login_credentials(int user_id) {
        List<String> credentials = new ArrayList<>();
        try {
            rs = stmt.executeQuery(manage_DDT.get_data("LoginCredentials") + "'" + user_id + "'");
            rs.next();
            String[] indexes = (manage_DDT.get_data("LoginIndexes")).split(",");
            for (int index = 0; index < indexes.length; index++) {
                credentials.add(rs.getString(Integer.parseInt(indexes[index])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return credentials;
    }

    @Step("Getting user details from the DB.")
    public static List<String> get_user_contact_details(int user_id) {

        List<String> contactDetails = new ArrayList<>();
        try {
            rs = stmt.executeQuery(manage_DDT.get_data("UserContactDetails") + "'" + user_id + "'");
            rs.next();
            String[] indexes = (manage_DDT.get_data("ContactIndexes")).split(",");
            for (int index = 0; index < indexes.length; index++) {
                contactDetails.add(rs.getString(Integer.getInteger(indexes[index])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return contactDetails;
    }

}
