package Extenstions;

import Utilities.common_ops;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import java.util.List;

import static org.testng.Assert.*;

public class verifications extends common_ops {

    @Step("Verify the text in element is the same as expected text")
    public static void element_text(WebElement elem, String expected_text, String massage) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected_text, massage);
    }

    @Step("Verify the actual text is the same as expected text")
    public static void string_value(String actual_text, String expected_text, String massage) {
        assertEquals(actual_text, expected_text, massage);
    }

    @Step("Verify the actual number is the same as expected number")
    public static void number_value(int actual_number, int expected_number, String massage) {
        assertEquals(actual_number, expected_number, massage);
    }

    @Step("Verify all actual texts is the same as expects text")
    public static void string_values(List<String> actual_texts, List<String> expected_texts, String massage) {
        if (actual_texts == null || expected_texts == null) {
            fail();
        }
        soft_assert = new SoftAssert();
        for (int index = 0; index < actual_texts.size() && index < expected_texts.size(); index++) {
            soft_assert.assertEquals(actual_texts.get(index), expected_texts.get(index), massage);
        }
        soft_assert.assertAll();
    }

    @Step("Verify if element is exists in screen")
    public static void is_elem_exists(WebElement elem, Boolean expected_result, String massage) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        is_elem_exists_without_wait(elem, expected_result, massage);
    }

    @Step("Verify if element is exists in screen")
    public static void is_elem_exists_without_wait(WebElement elem, Boolean expected_result, String massage) {
        if (expected_result) {
            assertTrue(elem.isDisplayed(), massage);
        } else assertFalse(expected_result);
    }

    @Step("Verify condition")
    public static void verify_condition(boolean expected_result, boolean condition, String massage) {
        if (expected_result) {
            assertTrue(condition, massage);
        }
        else assertFalse(condition, massage);
    }
}
