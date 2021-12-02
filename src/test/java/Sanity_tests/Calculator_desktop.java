package Sanity_tests;

import Utilities.common_ops;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import work_flows.desktop_flows;

public class Calculator_desktop extends common_ops {

    @Test(priority = 0, description = "Test01: Mathematical exercise of addition action.")
    @Description("Test description: test mathematical exercise of addition action.")
    public void Addition() {
        desktop_flows.calc_it("4+2");
        desktop_flows.verify_calc_result("6", "addition");
    }

    @Test(priority = 1, description = "Test02: Mathematical exercise of combination action.")
    @Description("Test description: test mathematical exercise of combination action.")
    public void Combination() {
        desktop_flows.calc_it("10*3+5=/7");
        desktop_flows.verify_calc_result("5", "combination");
    }

    @Test(priority = 2, description = "Test03: Mathematical exercise of division action.")
    @Description("Test description: test mathematical exercise of division action.")
    public void Division() {
        desktop_flows.calc_it("22/11");
        desktop_flows.verify_calc_result("2", "division");
    }

    @Test(priority = 3, description = "Test04: Mathematical exercise of multiplication action.")
    @Description("Test description: test mathematical exercise of multiplication action.")
    public void Multiplication() {
        desktop_flows.calc_it("9*5");
        desktop_flows.verify_calc_result("45", "multiplication");
    }

    @Test(priority = 4, description = "Test05: Mathematical exercise of subtraction action.")
    @Description("Test description: test mathematical exercise of subtraction action.")
    public void Subtraction() {
        desktop_flows.calc_it("8-6");
        desktop_flows.verify_calc_result("2", "subtraction");
    }

}
