package Page_objects.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Main_page {

    @FindBy(xpath = "//*[@id='etAmount']")
    private AndroidElement _Amount;
    @FindBy(xpath = "//*[@id='etTerm']")
    private AndroidElement _Term;
    @FindBy(xpath = "//*[@id='etRate']")
    private AndroidElement _Rate;

    @Step("Get amount element")
    public AndroidElement get_Amount() {
        return _Amount;
    }

    @Step("Get term element")
    public AndroidElement get_Term() {
        return _Term;
    }

    @Step("Get rate element")
    public AndroidElement get_Rate() {
        return _Rate;
    }

    @Step("Get calculator element")
    public AndroidElement getCalculate_btn() {
        return Calculate_btn;
    }

    @Step("Get save element")
    public AndroidElement getSave_btn() {
        return Save_btn;
    }

    @Step("Get alert element")
    public AndroidElement getAlert_saved() {
        return Alert_saved;
    }

    @Step("Get repayment element")
    public AndroidElement getRepaymentVal() {
        return RepaymentVal;
    }

    @Step("Get interest element")
    public AndroidElement getInterestVal() {
        return InterestVal;
    }

    @Step("Get delete element")
    public AndroidElement getDelete_btn() {
        return Delete_btn;
    }

    @Step("Get popup element")
    public AndroidElement getPOPUP() {
        return POPUP;
    }

    @FindBy(xpath = "//*[@text='Calculate']")
    private AndroidElement Calculate_btn;
    @FindBy(xpath = "//*[@id='btnSave']")
    private AndroidElement Save_btn;
    @FindBy(xpath = "//*[@text='Saved']")
    private AndroidElement Alert_saved;
    @FindBy(xpath = "//*[@id='tvRepayment']")
    private AndroidElement RepaymentVal;
    @FindBy(xpath = "//*[@id='tvInterestOnly']")
    private AndroidElement InterestVal;
    @FindBy(xpath = "//*[@id='btnDel']")
    private AndroidElement Delete_btn;
    @FindBy(xpath = "//*[@id='button1']")
    private AndroidElement POPUP;

    public Main_page(AppiumDriver mobileDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

}
