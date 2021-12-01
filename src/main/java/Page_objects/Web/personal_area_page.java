package Page_objects.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class personal_area_page {

    @FindBy(css = "#reactRoot > div > nav > div.css-1y6y4so > div.css-1cd0a4j.dropdown > a > span > div > svg")
    public WebElement configurationBtn;


    // user_configuration_plugins

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[1]/div/div/nav/div[2]/ul/li[4]/a")
    public WebElement Plug;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[3]/div/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/label[1]")
    public WebElement SelectAll;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[3]/div/div[1]/div/div[2]/div/div/div[1]/div[1]/div/input")
    public WebElement SearchBox;

    @FindBy(tagName = "h2")
    public WebElement SearchResult;



    // user_preferences

    @FindBy(id = "edit-user-profile-email")
    public WebElement inp_email;

    @FindBy(id = "edit-user-profile-username")
    public WebElement inp_name;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div/div[2]/form/fieldset/div[1]/div[2]/div/label[3]")
    public WebElement lightThemeBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div/div[2]/form/fieldset/div[1]/div[2]/div/label[2]")
    public WebElement darkThemeBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div/div[2]/form/fieldset/div[4]/button")
    public WebElement saveChangesBtn;

    @FindBy(how = How.XPATH, using = "//*[@class='page-container page-body']")
    public WebElement pageContainer;


    // user_personal_actions

    @FindBy(css = "span > img")
    public WebElement btn_user_actions_navigate;

    @FindBy(css = "#reactRoot > div > nav > div.css-3tq5ro > div.css-13ke808.dropdown.dropup > ul > li:nth-child(4) > a")
    public WebElement btn_sign_out;

}