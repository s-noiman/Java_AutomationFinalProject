package Page_objects.Web;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class password_page {

    @FindBy(css = "div.css-66nrdr-vertical-group > div:nth-child(2) > button")
    private WebElement btn_skip;

    @Step("Get skip button element.")
    public WebElement get_btn_skip() {
        return btn_skip;
    }
}
