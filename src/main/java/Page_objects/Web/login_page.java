package Page_objects.Web;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_page {

    @FindBy(css = "div:nth-child(1) > div:nth-child(2) > div > div > input")
    private WebElement inp_user_name;

    @FindBy(id ="current-password")
    private WebElement inp_password;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div/div/div[2]/div")
    private WebElement alert_message;


    @Step("Get user name input element.")
    public WebElement get_inp_user_name() {
        return inp_user_name;
    }

    @Step("Get user password input element.")
    public WebElement get_inp_password() {
        return inp_password;
    }

    @Step("Get alert massage element.")
    public WebElement get_alert_message() {
        return alert_message;
    }
}
