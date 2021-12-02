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

    @Step("Verify calculate=or action results")
    public static void verify_calc_results() {
        verifications.string_values(str_list, get_calc_result(),
                "There is no match between the current actual user details and the expected details.");
    }

    @Step("Save current calculation")
    public static void Save() {
        UI_actions.click(_main_page.getSave_btn());
    }

    @Step("Verify sava action")
    public static void verify_save_action() {
        verifications.is_elem_exists(_main_page.getAlert_saved(), true, "Calculation did not saved.");
    }

    @Step("Delete assignment")
    public static void Delete_Assignment() {
        UI_actions.click(_main_page.getDelete_btn());
        UI_actions.click(_main_page.getPOPUP());
    }

    @Step("Verify delete assignment")
    public static void verify_delete_assignment(boolean expected_result, String massage) {
        verifications.is_elem_exists_without_wait(_main_page.getDelete_btn(), expected_result, massage);

    }

}
