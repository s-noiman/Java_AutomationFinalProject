package Page_objects.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_page {

    @FindBy(css = "div:nth-child(1) > div:nth-child(2) > div > div > input")
    public WebElement inp_user_name;

    @FindBy(id ="current-password")
    public WebElement inp_password;

    @FindBy(css = "form > button")
    public WebElement btn_login;

    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/img")
    public WebElement grafana_icon;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div/div/div[2]/div")
    public WebElement alert_message;
}
