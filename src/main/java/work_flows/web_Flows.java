package work_flows;

import Extenstions.DB_actions;
import Extenstions.UI_actions;
import Utilities.auxiliary_methods;
import Utilities.common_ops;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

public class web_Flows extends common_ops {

    @Step("Login Grafana flow with credentials from DB.")
    public static void log_in(int user_id) {
        List<String> login_credentials = DB_actions.get_login_credentials(user_id);
        UI_actions.update_text(_login.inp_user_name, login_credentials.get(0));
        UI_actions.update_text(_login.inp_password, login_credentials.get(1));
        UI_actions.click(_login.btn_login);
    }

    @Step("User personal area navigation.")
    public static void navigate_to_personal_area() {
        UI_actions.click(_password.btn_skip);
    }

    @Step("Specific plugin searching.")
    public static void search_plugin(String search_text) {
        UI_actions.click(_personal_area.configurationBtn);
        UI_actions.click(_personal_area.Plug);
        UI_actions.update_text(_personal_area.SearchBox, search_text);
    }

    @Step("Receive user name and e-mail.")
    public static List<String> get_user_details() {
        UI_actions.click(_personal_area.btn_user_actions_navigate);
        return Arrays.asList(new String[] {UI_actions.get_attribute_value(_personal_area.inp_name, "value"),
                UI_actions.get_attribute_value(_personal_area.inp_email, "value")});
    }

    @Step("Change to light background color.")
    public static String change_to_light_background_color() {
        UI_actions.click(_personal_area.lightThemeBtn);
        UI_actions.click(_personal_area.saveChangesBtn);
        auxiliary_methods.sleep(1);
        return _personal_area.pageContainer.getCssValue("background-color");
    }

    @Step("Log out Grafana.")
    public static void log_out() {
        UI_actions.click(_personal_area.btn_user_actions_navigate);
        UI_actions.click(_personal_area.btn_sign_out);
    }

}
