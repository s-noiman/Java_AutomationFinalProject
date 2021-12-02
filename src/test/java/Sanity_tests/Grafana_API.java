package Sanity_tests;

import Extenstions.DB_actions;
import Utilities.common_ops;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import work_flows.API_flows;

public class Grafana_API extends common_ops {

    @Test(priority = 0, description = "Test01: GET http request.")
    @Description("Test Description: Verify status code of get user by login/e-mail request.")
    public void Get_request() {
        API_flows.get_user_by_login_or_email(DB_actions.get_login_credentials(2).get(0));
    }

    @Test(priority = 1, description = "Test02: PUT http request.")
    @Description("Test Description: Verify status code of change password request.")
    public void PUT_request() {
        API_flows.change_password(2,"admin");
    }

    @Test(priority = 2, description = "Test03: POST http request.")
    @Description("Test Description: Verify status code of switch user context for signed in user request.")
    public void POST_request() {
        API_flows.switch_user_context_for_signed_in_user(1);
    }
}