package Utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;

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

}
