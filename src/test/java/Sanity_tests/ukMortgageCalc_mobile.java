package Sanity_tests;

import Extenstions.UI_actions;
import Extenstions.verifications;
import Utilities.common_ops;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import work_flows.mobile_flows;

public class ukMortgageCalc_mobile extends common_ops {

    @Test(priority = 0, description = "Test01: Calculate and sava")
    @Description("Test description: Calculate The Entered Data + Save The Result.")
    public void Calculate_Values() {
        mobile_flows.Calculate("9", "9", "10");
        str_list = mobile_flows.get_calc_result();
        mobile_flows.Save();
        Assert.assertTrue(_main_page.getAlert_saved().isDisplayed(), "SAVED");
    }

    @Test(priority = 1, description = "Test02: Verifying values")
    @Description("Test description: Verifying The RepaymentValue + InterestValue.")
    public void verifyValues() {
        verifications.string_values(str_list, mobile_flows.get_calc_result(),
                "There is no match between the current actual user details and the expected details.");
    }

    @Test(priority = 2, description = "Test03: Delete and save")
    @Description("Test description: Delete The Saved Data File . (Swipe Feature submitted)")
    public void Delete_ASSIGMENT() {
        UI_actions.swipe();
        mobile_flows.Delete_Assignment();
    }

}
