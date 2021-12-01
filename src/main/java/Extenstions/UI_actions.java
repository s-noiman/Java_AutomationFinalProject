package Extenstions;
import Utilities.common_ops;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UI_actions extends common_ops {

    @Step("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Get element attribute value")
    public static String get_attribute_value(WebElement elem, String attribute) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        return elem.getAttribute(attribute);
    }

    @Step("Sending text to text-field")
    public static void update_text(WebElement elem, String value) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Hover the mouse on a certain Element inorder to click secondary element")
    public static void mouse_hover_elements(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }
}
