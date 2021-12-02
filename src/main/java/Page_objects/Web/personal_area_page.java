package Page_objects.Web;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class personal_area_page {

    @FindBy(how = How.XPATH, using = "//div[6]/a")
    private WebElement configurationBtn;

    @Step("Get configuration button element.")
    public WebElement getConfigurationBtn() {
        return configurationBtn;
    }

    // user_configuration_plugins

    @FindBy(how = How.XPATH, using = "//nav/div[2]/ul/li[4]/a")
    private WebElement Plug;

    @FindBy(how = How.XPATH, using = "//div[2]/div/label[1]")
    private WebElement SelectAll;

    @FindBy(how = How.XPATH, using = "//div[1]/div[1]/div/input")
    private WebElement SearchBox;

    @FindBy(tagName = "h2")
    private WebElement SearchResult;

    @Step("Get plug button element.")
    public WebElement getPlug() {
        return Plug;
    }

    @Step("Get select all button element.")
    public WebElement getSelectAll() {
        return SelectAll;
    }

    @Step("Get search box element.")
    public WebElement getSearchBox() {
        return SearchBox;
    }

    @Step("Get search result element.")
    public WebElement getSearchResult() {
        return SearchResult;
    }

    // user_preferences

    @FindBy(id = "edit-user-profile-email")
    private WebElement inp_email;

    @FindBy(id = "edit-user-profile-username")
    private WebElement inp_name;

    @FindBy(how = How.XPATH, using = "//label[3]")
    private WebElement lightThemeBtn;

    @FindBy(how = How.XPATH, using = "//label[2]")
    private WebElement darkThemeBtn;

    @FindBy(how = How.XPATH, using = "//div[2]/form/fieldset/div[4]/button")
    private WebElement saveChangesBtn;

    @FindBy(how = How.XPATH, using = "//*[@class='page-container page-body']")
    private WebElement pageContainer;

    @Step("Get e-mail input element.")
    public WebElement get_inp_email() {
        return inp_email;
    }

    @Step("Get name input element.")
    public WebElement get_inp_name() {
        return inp_name;
    }

    @Step("Get light button element.")
    public WebElement getLightThemeBtn() {
        return lightThemeBtn;
    }

    @Step("Get dark button element.")
    public WebElement getDarkThemeBtn() {
        return darkThemeBtn;
    }

    @Step("Get sava button element.")
    public WebElement getSaveChangesBtn() {
        return saveChangesBtn;
    }

    @Step("Get page container element.")
    public WebElement getPageContainer() {
        return pageContainer;
    }


// user_personal_actions

    @FindBy(css = "div:nth-child(1) > a > span > img")
    private WebElement btn_user_actions_navigate;

    @FindBy(css = "div.css-1cd0a4j.dropdown.dropup > a > span > img")
    private WebElement btn_user_actions_navigate_after_change;

    @FindBy(css = "div.css-1cd0a4j.dropdown.dropup > ul > li:nth-child(4) > a")
    private WebElement btn_sign_out;

    @Step("Get profile navigator button element")
    public WebElement get_btn_user_actions_navigate() {
        return btn_user_actions_navigate;
    }

    @Step("Get profile navigator button element after change")
    public WebElement get_btn_user_actions_navigate_after_change() {
        return btn_user_actions_navigate_after_change;
    }

    @Step("Get sign out button element")
    public WebElement get_btn_sign_out() {
        return btn_sign_out;
    }
}
