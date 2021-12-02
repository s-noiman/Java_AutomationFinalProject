package Utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

import java.util.concurrent.TimeUnit;

import static Utilities.manage_DDT.get_data;

public class auxiliary_methods extends common_ops{

    @Step("Sleep action")
    public static void sleep(int wait_time) {
        Uninterruptibles.sleepUninterruptibly(wait_time, TimeUnit.SECONDS);
    }

    @Step("Print response result")
    public static void print_response(String header) {
        System.out.println("\n--  " + header + "  --");
        response.prettyPrint();
        System.out.println("\n");
    }

    @Step("Initialization response")
    static void init_http_response() {
        http_request = RestAssured.given();
        http_request.header("Content-Type", "application/json");
        http_request.header("Accept", "application/json");
        http_request.header("Authorization", get_data("Authorization_basic_key"));
    }

    @Step("Update response status code")
    static void update_response_status_code(int status_code) {
        integer = status_code;
    }

}
