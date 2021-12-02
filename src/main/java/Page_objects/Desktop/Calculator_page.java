package Page_objects.Desktop;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calculator_page {

    @FindBy(name = "Equals")
    private WebElement btn_equals;
    @FindBy(name = "Minus")
    private WebElement btn_minus;
    @FindBy(name = "Plus")
    private WebElement btn_plus;
    @FindBy(name = "Divide by")
    private WebElement btn_divide;
    @FindBy(name = "Multiply by")
    private WebElement btn_multiply;

    @Step("Get calculator result")
    public WebElement getTxt_calculator_result() {
        return txt_calculator_result;
    }

    @FindBy(xpath = "//*[@AutomationId='clearButton']")
    private WebElement btn_clear;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    private WebElement txt_calculator_result;

    @FindBy(name = "Zero")
    private WebElement btn_zero;

    @FindBy(name = "One")
    private WebElement btn_one;

    @Step("Get equals element")
    public WebElement getBtn_equals() {
        return btn_equals;
    }

    @Step("Get minus element")
    public WebElement getBtn_minus() {
        return btn_minus;
    }

    @Step("Get plus element")
    public WebElement getBtn_plus() {
        return btn_plus;
    }

    @Step("Get divide element")
    public WebElement getBtn_divide() {
        return btn_divide;
    }

    @Step("Get multiply element")
    public WebElement getBtn_multiply() {
        return btn_multiply;
    }

    @Step("Get clear element")
    public WebElement getBtn_clear() {
        return btn_clear;
    }

    @Step("Get zero element (0)")
    public WebElement getBtn_zero() {
        return btn_zero;
    }

    @Step("Get one element (1)")
    public WebElement getBtn_one() {
        return btn_one;
    }

    @Step("Get two element (2)")
    public WebElement getBtn_two() {
        return btn_two;
    }

    @Step("Get three element (3)")
    public WebElement getBtn_three() {
        return btn_three;
    }

    @Step("Get four element (4)")
    public WebElement getBtn_four() {
        return btn_four;
    }

    @Step("Get five element (5)")
    public WebElement getBtn_five() {
        return btn_five;
    }

    @Step("Get six element (6)")
    public WebElement getBtn_six() {
        return btn_six;
    }

    @Step("Get seven element (7)")
    public WebElement getBtn_seven() {
        return btn_seven;
    }

    @Step("Get eight element (8)")
    public WebElement getBtn_eight() {
        return btn_eight;
    }

    @Step("Get nine element (9)")
    public WebElement getBtn_nine() {
        return btn_nine;
    }

    @FindBy(name = "Two")
    private WebElement btn_two;
    @FindBy(name = "Three")
    private WebElement btn_three;
    @FindBy(name = "Four")
    private WebElement btn_four;
    @FindBy(name = "Five")
    private WebElement btn_five;
    @FindBy(name = "Six")
    private WebElement btn_six;
    @FindBy(name = "Seven")
    private WebElement btn_seven;
    @FindBy(name = "Eight")
    private WebElement btn_eight;
    @FindBy(name = "Nine")
    private WebElement btn_nine;

}
