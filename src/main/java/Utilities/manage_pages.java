package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class manage_pages extends base
{
    @Step("Initialization pages.")
    public static void init()
    {
        //Web page objects initialization.
        _login = PageFactory.initElements(driver, Page_objects.Web.login_page.class);
        _password = PageFactory.initElements(driver, Page_objects.Web.password_page.class);
        _personal_area = PageFactory.initElements(driver, Page_objects.Web.personal_area_page.class);

        //Desktop page objects initialization.
        _calc_page = PageFactory.initElements(windows_driver, Page_objects.Desktop.Calculator_page.class);

        //Electron page objects initialization.
        _todo = PageFactory.initElements(driver, Page_objects.Electron.todo_page.class);
    }

    @Step("Initializing mobile driver.")
    public static void init_app()
    {
        _main_page = new Page_objects.Mobile.Main_page(mobile_driver);
    }
}

