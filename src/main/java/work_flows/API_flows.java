package work_flows;

import Extenstions.API_actions;
import Utilities.common_ops;
import Utilities.auxiliary_methods;
import io.qameta.allure.Step;

public class API_flows extends common_ops {

    @Step("get_user_by_login_or_email")
    public static void get_user_by_login_or_email(String login_or_email) {
        API_actions.GET_request_by_login_or_email(login_or_email);
        auxiliary_methods.print_response("GET request");
    }

    @Step("change_password")
    public static void change_password(String new_password) {
        API_actions.PUT_request_change_password(password, new_password);
        auxiliary_methods.print_response("PUT request");
    }

    @Step("switch_user_context_for_signed_in_user")
    public static void switch_user_context_for_signed_in_user(int auth_token_ID) {
        API_actions.POST_request_switch_user_context_for_signed_in_user(auth_token_ID);
        auxiliary_methods.print_response("POST request");
    }


}
