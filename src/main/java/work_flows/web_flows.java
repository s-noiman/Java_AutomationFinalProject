package work_flows;

import Extenstions.DB_actions;
import Extenstions.UI_actions;
import Extenstions.verifications;
import Utilities.auxiliary_methods;
import Utilities.common_ops;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;
import org.sikuli.script.FindFailed;

import java.util.Arrays;
import java.util.List;

public class web_flows extends common_ops {

    @Step("Login Grafana flow with credentials from DB.")
    public static void log_in(int user_id) throws FindFailed {
        List<String> login_credentials = DB_actions.get_login_credentials(user_id);
        UI_actions.update_text(_login.inp_user_name, login_credentials.get(0));
        UI_actions.update_text(_login.inp_password, login_credentials.get(1));
        UI_actions.sikuli_click("Login_btn");
    }

    @Step("Verify login action")
    public static void verify_log_in() {
        verifications.element_text(_login.alert_message, "Logged in", "The login to Grafana was not performed as expected.");
    }

    @Step("User personal area navigation.")
    public static void navigate_to_personal_area() {
        UI_actions.click(_password.btn_skip);
    }

    @Step("Specific plugin searching.")
    public static void search_plugin(String search_text) {
        UI_actions.click(_personal_area.configurationBtn);
        UI_actions.click(_personal_area.Plug);
        auxiliary_methods.sleep(3);
        UI_actions.click(_personal_area.SelectAll);
        UI_actions.update_text(_personal_area.SearchBox, search_text);
        auxiliary_methods.sleep(5);
    }

    @Step("Verify search action")
    public static void verify_search_action(boolean expected_result) {
        verifications.is_elem_exists(_personal_area.SearchResult, expected_result, "Any search result founded.");
    }

    @Step("Receive user name and e-mail.")
    public static List<String> get_user_details() {
        UI_actions.click(_personal_area.btn_user_actions_navigate);
        return Arrays.asList(new String[] {UI_actions.get_attribute_value(_personal_area.inp_name, "value"),
                UI_actions.get_attribute_value(_personal_area.inp_email, "value")});
    }

    @Step("Verify search action")
    public static void verify_user_details(int user_id) {
        verifications.string_values(web_flows.get_user_details(), DB_actions.get_user_contact_details(user_id),
                "There is no match between the current actual user details and the expected details.");
    }

    @Step("Change to light background color.")
    public static String change_to_light_background_color() {
        UI_actions.click(_personal_area.lightThemeBtn);
        UI_actions.click(_personal_area.saveChangesBtn);
        auxiliary_methods.sleep(1);
        return _personal_area.pageContainer.getCssValue("background-color");
    }

    @Step("Verify  screen mode")
    public static void verify_screen_mode(String color) {
        verifications.string_value(Color.fromString(web_flows.change_to_light_background_color()).asHex(), color, "Background color has not changed");
    }

    @Step("Change to dark background color.")
    public static void change_to_dark_mode() {
        UI_actions.click(_personal_area.darkThemeBtn);
        UI_actions.click(_personal_area.saveChangesBtn);
    }

    @Step("Log out Grafana.")
    public static void log_out() {
        UI_actions.click_without_waiting(_personal_area.btn_user_actions_navigate_after_change);
        UI_actions.click_without_waiting(_personal_area.btn_sign_out);
    }

    @Step("Change to dark background color.")
    public static void verify_log_out() {
        verifications.string_value(driver.getCurrentUrl(), get_data("url"), "The log out was not performed as expected.");
    }

}
