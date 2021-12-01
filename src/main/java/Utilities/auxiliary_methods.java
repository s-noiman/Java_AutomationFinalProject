package Utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

public class auxiliary_methods {

    @Step("Sleep action")
    public static void sleep(int wait_time) {
        Uninterruptibles.sleepUninterruptibly(wait_time, TimeUnit.SECONDS);
    }
}
