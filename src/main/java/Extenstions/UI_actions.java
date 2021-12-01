package Extenstions;
import Utilities.auxiliary_methods;
import Utilities.common_ops;
import Utilities.manage_pages;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;

public class UI_actions extends common_ops {

    @Step("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    @Step("Click on Element")
    public static void click(AndroidElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    @Step("Get element attribute value")
    public static String get_attribute_value(WebElement elem, String attribute) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        return elem.getAttribute(attribute);
    }

    @Step("Sending text to text-field")
    public static void update_text(WebElement elem, String value) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Sending text to text-field")
    public static void update_text(AndroidElement elem, String value) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Hover the mouse on a certain Element inorder to click secondary element")
    public static void mouse_hover_elements(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Click on element by sikuli")
    public static void sikuli_click(String img_name) throws FindFailed {
        screen.click( get_data("ImageRepo") + img_name + ".png");
    }


}
