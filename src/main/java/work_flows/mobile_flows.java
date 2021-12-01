package work_flows;

import Extenstions.UI_actions;
import Extenstions.verifications;
import Utilities.common_ops;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class mobile_flows extends common_ops {

    @Step
    public static void Calculate(String amount, String term, String rate) {
        UI_actions.update_text(_main_page.get_Amount(), amount);
        UI_actions.update_text(_main_page.get_Term(), term);
        UI_actions.update_text(_main_page.get_Rate(), rate);
        UI_actions.click(_main_page.getCalculate_btn());
    }

    @Step
    public static List<String> get_calc_result() {
        return Arrays.asList(new String[] {_main_page.getRepaymentVal().getText(), _main_page.getInterestVal().getText()});
    }

    @Step
    public static void Save() {
        UI_actions.click(_main_page.getSave_btn());
    }

    @Step
    public static void swipe() {
        t.press(PointOption.point(900, 300)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                moveTo(PointOption.point(0, 400)).release().perform();
    }
    @Step
    public static void Delete_Assigment() {
        UI_actions.click(_main_page.getDelete_btn());
        UI_actions.click(_main_page.getPOPUP());
        verifications.is_elem_exists_without_wait(_main_page.getDelete_btn(), false, "");
    }

}
