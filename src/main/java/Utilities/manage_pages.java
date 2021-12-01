package Utilities;

import org.openqa.selenium.support.PageFactory;

public class manage_pages extends base
{
    public static void init()
    {
        //Web page objects initialization.
        _login = PageFactory.initElements(driver, Page_objects.Web.login_page.class);
        _password = PageFactory.initElements(driver, Page_objects.Web.password_page.class);
        _personal_area = PageFactory.initElements(driver, Page_objects.Web.personal_area_page.class);

        //Mobile page objects initialization.

    }

    //Initializing mobile driver.
//    public static void init_app()
//    {
//        mainPageMobile = new mainPageMobile(mobileDriver);
//    }
}

