package Extenstions;

import Utilities.base;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

public class API_actions extends base {

    @Step("Get data from server")
    public static void GET_request_by_login_or_email(String login_or_email) {
        init_http_response();
        response = http_request.get(http_request_url + "users/lookup?loginOrEmail=" + login_or_email);
        update_response_status_code(response.getStatusCode());
    }

    @Step
    public static void PUT_request_change_password(String old_password, String new_password) {
        init_http_response();
        params.put("oldPassword", old_password);
        params.put("newPassword", new_password);
        http_request.body(params.toJSONString());
        response = http_request.put(http_request_url + "user/password");
        update_response_status_code(response.getStatusCode());
    }

    @Step
    public static void POST_request_switch_user_context_for_signed_in_user(int auth_token_ID) {
        init_http_response();
        response = http_request.post(http_request_url + "user/using/" + auth_token_ID);
        update_response_status_code(response.getStatusCode());
    }

    @Step("Initialization response")
    private static void init_http_response() {
        http_request = RestAssured.given();
        http_request.header("Content-Type", "application/json");
        http_request.header("Accept", "application/json");
        http_request.header("Authorization", authorization_basic_key);
    }

    @Step("Update response status code")
    private static void update_response_status_code(int status_code) {
        http_request_status_code = status_code;
    }

}