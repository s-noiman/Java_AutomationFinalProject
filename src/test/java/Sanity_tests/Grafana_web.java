package Sanity_tests;

import Extenstions.DB_actions;
import Utilities.common_ops;
import io.qameta.allure.Description;
import org.openqa.selenium.support.Color;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import work_flows.web_Flows;
import Extenstions.verifications;

@Listeners(Utilities.listeners.class)
public class Grafana_web extends common_ops {

    @Test(priority = 0, description = "Verify left side avatar image")
    @Description("Test Description: Verifing that the left side Avaza avatar image isn't change between tests")
    public void test07_visualTestingOfTheAvatar() {
        verifications.VisualElement(_login.grafana_icon, "Grafana_icon");
    }


    @Test(priority = 1, description = "Test01: Login Grafana website with credentials.")
    @Description("Test Description: Login Grafana Web Application.")
    public void login() throws FindFailed {
        web_Flows.log_in(1);
        verifications.element_text(_login.alert_message, "Logged in", "The login to Grafana was not performed as expected.");
    }

    @Test(priority = 2, description = "Test02: Plugin searching.")
    @Description("Test Description:  Verify plugin searching result.")
    public void verify_plugin_searching_result() {
        web_Flows.navigate_to_personal_area();
        web_Flows.search_plugin("AJAX");
        verifications.is_elem_exists(_personal_area.SearchResult, true, "Any search result founded.");
    }

    @Test(priority = 3, description = "Test03: User details.")
    @Description("Test Description:  Verify user name and e-mail.")
    public void verify_users_details() {
        verifications.string_values(web_Flows.get_user_details(), DB_actions.get_user_contact_details(1),
                "There is no match between the current actual user details and the expected details.");
    }

    @Test(priority = 4, description = "Test04: Change user settings.")
    @Description("Test Description: Change the user background colors settings.")
    public void change_to_light_background_color() {
        verifications.string_value(Color.fromString(web_Flows.change_to_light_background_color()).asHex(), "#ffffff", "Background color has not changed");
    }

    @Test(priority = 5, testName = "Test05: Log out the site")
    @Description("Test Description: Verification of logout the site.")
    public void test_logout() {
        web_Flows.log_out();
        verifications.string_value(driver.getCurrentUrl(), get_data("url"), "The log out was not performed as expected.");
    }

}
