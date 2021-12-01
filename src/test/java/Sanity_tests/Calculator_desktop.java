package Sanity_tests;

import Extenstions.UI_actions;
import Utilities.common_ops;
import org.testng.annotations.Test;
import work_flows.desktop_flows;
import Extenstions.verifications;

public class Calculator_desktop extends common_ops {
    @Test
    public void Addition() {
        desktop_flows.calc_it("4+2");
        verifications.string_value(desktop_flows.get_calculator_result(), "6", "The addition operation did not work as expected.");
    }

    @Test
    public void Combination() {
        desktop_flows.calc_it("10*3+5=/7");
        verifications.string_value(desktop_flows.get_calculator_result(), "5", "The combination operation did not work as expected.");
    }

    @Test
    public void Division() {
        desktop_flows.calc_it("22/11");
        verifications.string_value(desktop_flows.get_calculator_result(), "2", "The division operation did not work as expected.");
    }

    @Test
    public void Multiplication() {
        desktop_flows.calc_it("9*5");
        verifications.string_value(desktop_flows.get_calculator_result(), "45", "The multiplication operation did not work as expected.");
    }

    @Test
    public void Subtraction() {
        desktop_flows.calc_it("8-6");
        verifications.string_value(desktop_flows.get_calculator_result(), "2", "The subtraction operation did not work as expected.");
    }

}
