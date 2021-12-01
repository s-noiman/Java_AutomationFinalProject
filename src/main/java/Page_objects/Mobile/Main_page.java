package Page_objects.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Main_page {

    @FindBy(xpath = "//*[@id='etAmount']")
    private AndroidElement _Amount;
    @FindBy(xpath = "//*[@id='etTerm']")
    private AndroidElement _Term;
    @FindBy(xpath = "//*[@id='etRate']")
    private AndroidElement _Rate;

    public AndroidElement get_Amount() {
        return _Amount;
    }

    public AndroidElement get_Term() {
        return _Term;
    }

    public AndroidElement get_Rate() {
        return _Rate;
    }

    public AndroidElement getCalculate_btn() {
        return Calculate_btn;
    }

    public AndroidElement getSave_btn() {
        return Save_btn;
    }

    public AndroidElement getAlert_saved() {
        return Alert_saved;
    }

    public AndroidElement getRepaymentVal() {
        return RepaymentVal;
    }

    public AndroidElement getInterestVal() {
        return InterestVal;
    }

    public AndroidElement getDelete_btn() {
        return Delete_btn;
    }

    public AndroidElement getPOPUP() {
        return POPUP;
    }

    public AppiumDriver getMobileDriver() {
        return mobileDriver;
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

    private AppiumDriver mobileDriver;

    public Main_page(AppiumDriver mobileDriver)
    {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

}
