package work_flows;

import Extenstions.UI_actions;
import Extenstions.verifications;
import Utilities.common_ops;
import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;

public class mobile_flows extends common_ops {

    @Step("Calculation of result by amount, term, rate values")
    public static void Calculate(String amount, String term, String rate) {
        UI_actions.update_text(_main_page.get_Amount(), amount);
        UI_actions.update_text(_main_page.get_Term(), term);
        UI_actions.update_text(_main_page.get_Rate(), rate);
        UI_actions.click(_main_page.getCalculate_btn());
    }

    @Step("Get calc result")
    public static List<String> get_calc_result() {
        return Arrays.asList(new String[] {_main_page.getRepaymentVal().getText(), _main_page.getInterestVal().getText()});
    }

    @Step("Save current calculation")
    public static void Save() {
        UI_actions.click(_main_page.getSave_btn());
    }

    @Step("Delete assignment")
    public static void Delete_Assignment() {
        UI_actions.click(_main_page.getDelete_btn());
        UI_actions.click(_main_page.getPOPUP());
        verifications.is_elem_exists_without_wait(_main_page.getDelete_btn(), false, "");
    }

}
