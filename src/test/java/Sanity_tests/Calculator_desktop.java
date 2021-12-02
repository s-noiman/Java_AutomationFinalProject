package Sanity_tests;

import Utilities.common_ops;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import work_flows.desktop_flows;
import Extenstions.verifications;

public class Calculator_desktop extends common_ops {

    @Test(priority = 0, description = "Test01: Mathematical exercise of addition action.")
    @Description("Test description: test mathematical exercise of addition action.")
    public void Addition() {
        desktop_flows.calc_it("4+2");
        verifications.string_value(desktop_flows.get_calculator_result(), "6", "The addition operation did not work as expected.");
    }

    @Test(priority = 1, description = "Test02: Mathematical exercise of combination action.")
    @Description("Test description: test mathematical exercise of combination action.")
    public void Combination() {
        desktop_flows.calc_it("10*3+5=/7");
        verifications.string_value(desktop_flows.get_calculator_result(), "5", "The combination operation did not work as expected.");
    }

    @Test(priority = 2, description = "Test03: Mathematical exercise of division action.")
    @Description("Test description: test mathematical exercise of division action.")
    public void Division() {
        desktop_flows.calc_it("22/11");
        verifications.string_value(desktop_flows.get_calculator_result(), "2", "The division operation did not work as expected.");
    }

    @Test(priority = 3, description = "Test04: Mathematical exercise of multiplication action.")
    @Description("Test description: test mathematical exercise of multiplication action.")
    public void Multiplication() {
        desktop_flows.calc_it("9*5");
        verifications.string_value(desktop_flows.get_calculator_result(), "45", "The multiplication operation did not work as expected.");
    }

    @Test(priority = 4, description = "Test05: Mathematical exercise of subtraction action.")
    @Description("Test description: test mathematical exercise of subtraction action.")
    public void Subtraction() {
        desktop_flows.calc_it("8-6");
        verifications.string_value(desktop_flows.get_calculator_result(), "2", "The subtraction operation did not work as expected.");
    }

}
