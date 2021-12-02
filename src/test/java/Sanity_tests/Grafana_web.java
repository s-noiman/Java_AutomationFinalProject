package Sanity_tests;

import Extenstions.DB_actions;
import Utilities.base;
import Utilities.common_ops;
import io.qameta.allure.Description;
import org.openqa.selenium.support.Color;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import work_flows.web_flows;

public class Grafana_web extends common_ops {

    @Test(priority = 0, description = "Test01: Login Grafana website with credentials.")
    @Description("Test Description: Login Grafana Web Application.")
    public void login() throws FindFailed {
        web_flows.log_in(2);
        web_flows.verify_log_in();
    }

    @Test(priority = 1, description = "Test02: Plugin searching.")
    @Description("Test Description:  Verify plugin searching result.")
    public void verify_plugin_searching_result() {
        web_flows.search_plugin("AJAX");
        web_flows.verify_search_action(true);
    }

    @Test(priority = 2, description = "Test03: User details.")
    @Description("Test Description:  Verify user name and e-mail.")
    public void verify_users_details() {
      web_flows.verify_user_details(2);
    }

    @Test(priority = 3, description = "Test04: Change user settings.")
    @Description("Test Description: Change the user background colors settings.")
    public void change_to_light_background_color() {
        web_flows.change_to_light_background_color();
        web_flows.verify_screen_mode(white_hex_color);
    }

    @Test(priority = 4, testName = "Test05: Log out the site")
    @Description("Test Description: Verification of logout the site.")
    public void test_logout() {
        web_flows.change_to_dark_mode();
        web_flows.log_out();
        web_flows.verify_log_out();
    }

}
