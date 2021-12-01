package Sanity_tests;

import Extenstions.DB_actions;
import Extenstions.verifications;
import Utilities.common_ops;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import work_flows.mobile_flows;
import work_flows.web_flows;

public class ukMortgageCalc_mobile extends common_ops {
    List<String> calc_result;

    @Test(priority = 1)
    @Description("Calculate The Entered Data + Save The Result.")
    public void Calculate_Values() {
        mobile_flows.Calculate("9", "9", "10");
        calc_result = mobile_flows.get_calc_result();
        mobile_flows.Save();
        Assert.assertTrue(_main_page.getAlert_saved().isDisplayed(), "SAVED");
    }

    @Test(priority = 2)
    @Description("Verifying The RepaymentValue + InterestValue.")
    public void verifyValues() {
        verifications.string_values(calc_result, mobile_flows.get_calc_result(),
                "There is no match between the current actual user details and the expected details.");
    }

    @Test(priority = 3)
    @Description("Delete The Saved Data File . (Swipe Feature submitted)")
    public void Delete_ASSIGMENT() {
        mobile_flows.swipe();
        mobile_flows.Delete_Assigment();
    }

}
