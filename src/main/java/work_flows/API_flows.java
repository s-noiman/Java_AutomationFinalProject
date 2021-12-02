package work_flows;

import Extenstions.API_actions;
import Extenstions.DB_actions;
import Utilities.common_ops;
import Utilities.auxiliary_methods;
import io.qameta.allure.Step;

public class API_flows extends common_ops {

    @Step("Get user by login or email")
    public static void get_user_by_login_or_email(String login_or_email) {
        API_actions.GET_request_by_login_or_email(login_or_email);
        auxiliary_methods.print_response("GET request");
    }

    @Step("Change password")
    public static void change_password(int user_id, String new_password) {
        API_actions.PUT_request_change_password(DB_actions.get_login_credentials(user_id).get(1), new_password);
        auxiliary_methods.print_response("PUT request");
    }

    @Step("Switch user context for signed in user")
    public static void switch_user_context_for_signed_in_user(int auth_token_ID) {
        API_actions.POST_request_switch_user_context_for_signed_in_user(auth_token_ID);
        auxiliary_methods.print_response("POST request");
    }

}
