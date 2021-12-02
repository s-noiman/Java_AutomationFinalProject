package work_flows;

import Extenstions.UI_actions;
import Extenstions.verifications;
import Utilities.common_ops;
import io.qameta.allure.Step;

public class desktop_flows extends common_ops {

    @Step("Get calculator result")
    public static String get_calculator_result() {
        return _calc_page.getTxt_calculator_result().getText().replace("Display is", "").trim();
    }

    @Step("Calculating an arithmetic exercise")
    public static void calc_it(String exercise) {
        for(int index = 0; index < exercise.length(); index++) {
            if (Character.isDigit(exercise.charAt(index))) {
                number_detection(Integer.parseInt(String.valueOf(exercise.charAt(index))));
            }
            else char_detection(exercise.charAt(index));
        }
        UI_actions.click_without_waiting(_calc_page.getBtn_equals());
    }

    @Step("Identify a number and send for click")
    public static void number_detection(int num) {
        switch (num) {
            case 1:
                UI_actions.click_without_waiting(_calc_page.getBtn_one());
                break;
            case 2:
                UI_actions.click_without_waiting(_calc_page.getBtn_two());
                break;
            case 3:
                UI_actions.click_without_waiting(_calc_page.getBtn_three());
                break;
            case 4:
                UI_actions.click_without_waiting(_calc_page.getBtn_four());
                break;
            case 5:
                UI_actions.click_without_waiting(_calc_page.getBtn_five());
                break;
            case 6:
                UI_actions.click_without_waiting(_calc_page.getBtn_six());
                break;
            case 7:
                UI_actions.click_without_waiting(_calc_page.getBtn_seven());
                break;
            case 8:
                UI_actions.click_without_waiting(_calc_page.getBtn_eight());
                break;
            case 9:
                UI_actions.click_without_waiting(_calc_page.getBtn_nine());
                break;
            case 0:
                UI_actions.click_without_waiting(_calc_page.getBtn_zero());
                break;
            default:
                break;
        }
    }

    @Step("Identify a arithmetic action and send for click")
    public static void char_detection(char ch) {
        switch (ch) {
            case '+':
                UI_actions.click_without_waiting(_calc_page.getBtn_plus());
                break;
            case '-':
                UI_actions.click_without_waiting(_calc_page.getBtn_minus());
                break;
            case '/':
                UI_actions.click_without_waiting(_calc_page.getBtn_divide());
                break;
            case '*':
                UI_actions.click_without_waiting(_calc_page.getBtn_multiply());
                break;
            case '=':
                UI_actions.click_without_waiting(_calc_page.getBtn_equals());
                break;
            default:
                break;
        }
    }

    @Step("Verify calc result")
    public static void verify_calc_result(String excepted_result, String action) {
        verifications.string_value(desktop_flows.get_calculator_result(), excepted_result, "The " + action + " operation did not work as expected.");
    }

}
