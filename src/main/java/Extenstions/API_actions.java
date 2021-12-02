package Extenstions;

import Utilities.common_ops;
import io.qameta.allure.Step;

public class API_actions extends common_ops {

    @Step("GET request by login/email")
    public static void GET_request_by_login_or_email(String login_or_email) {
        response = http_request.get(http_request_url + "users/lookup?loginOrEmail=" + login_or_email);
    }

    @Step("PUT request change password")
    public static void PUT_request_change_password(String old_password, String new_password) {
        params.put("oldPassword", old_password);
        params.put("newPassword", new_password);
        http_request.body(params.toJSONString());
        response = http_request.put(http_request_url + "user/password");
    }

    @Step("POST request switch user context for signed in user")
    public static void POST_request_switch_user_context_for_signed_in_user(int auth_token_ID) {
        response = http_request.post(http_request_url + "user/using/" + auth_token_ID);
    }

}
