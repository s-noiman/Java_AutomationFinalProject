package Utilities;

import Extenstions.UI_actions;
import Extenstions.verifications;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

import static Utilities.manage_DDT.get_data;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class common_ops extends base {


    @Step("Browser identification")
    private static void init_browser(String browserType) {
        switch (browserType.toLowerCase())
        {
            case "chrome":
                driver = init_Chrome_driver();
                break;
            case "firefox":
                driver = init_FF_driver();
                break;
            case "ie":
                driver = init_IE_driver();
                break;
            case "edge":
                driver = init_Edge_driver();
                break;
            default:
                throw new RuntimeException(("Invalid platform name stated."));
        }
        driver.manage().window().maximize();
        driver.get(manage_DDT.get_data("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(get_data("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(get_data("Timeout")));
        action = new Actions(driver);
        screen = new Screen();
    }

    @Step("Chrome browser initialization")
    private static WebDriver init_Chrome_driver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @Step("Firefox browser initialization")
    private static WebDriver init_FF_driver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    @Step("Internet explorer browser initialization")
    private static WebDriver init_IE_driver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    @Step("Edge browser initialization")
    private static WebDriver init_Edge_driver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    @Step("API initialization")
    private static void init_API() {
        RestAssured.baseURI = get_data("Grafana_API_URL");
        http_request = RestAssured.given();
        http_request_url = get_data("Grafana_API_URL");
        auxiliary_methods.init_http_response();
    }

    @Step("Mobile initialization")
    private static void init_mobile() {
        desired_capabilities = new DesiredCapabilities();
        desired_capabilities.setCapability(MobileCapabilityType.UDID, get_data("UDID"));
        desired_capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, get_data("APP_PACKAGE"));
        desired_capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, get_data("APP_ACTIVITY"));
        try
        {
            mobile_driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desired_capabilities);
        }
        catch (Exception e)
        {
            System.out.println("Cannot connect to appium server, see details: " + e);
        }
        wait = new WebDriverWait(mobile_driver, Long.parseLong(get_data("Timeout")));
        manage_pages.init_app();
        touch_action = new TouchAction(mobile_driver);
    }

    @Step("Desktop initialization")
    private static void init_desktop() throws MalformedURLException {
        desired_capabilities = new DesiredCapabilities();
        desired_capabilities = new DesiredCapabilities();
        desired_capabilities.setCapability("app", get_data("app"));
        windows_driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), desired_capabilities);
        windows_driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step("Electron initialization")
    private static void init_electron() {
        System.setProperty("webdriver.chrome.driver", get_data("ElectronDriverURL"));
        opt = new ChromeOptions();
        opt.setBinary(get_data("ElectURL"));
        desired_capabilities = new DesiredCapabilities();
        desired_capabilities.setCapability("chromeOptions", opt);
        desired_capabilities.setBrowserName("chrome");
        opt.merge(desired_capabilities);
        driver = new ChromeDriver(opt);
        action = new Actions(driver);
        integer = 0;
    }



    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) throws MalformedURLException {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            init_browser(get_data("BrowserName"));
        else if(platform.equalsIgnoreCase("mobile")) {
            init_mobile();
        }
        else if(platform.equalsIgnoreCase("api")) {
            init_API();
        }
        else if (platform.equalsIgnoreCase("desktop")) {
            init_desktop();
        }
        else if(platform.equalsIgnoreCase("electron")) {
            init_electron();
        }
        else
            throw new RuntimeException(("Invalid platform name stated"));
        manage_pages.init();
        manage_DB.init_DB_connection(get_data("DBURL"), get_data("DBUserName"), get_data("DBPassword"));
    }

    @BeforeMethod
    public void beforeMethod() {
        if (platform.equalsIgnoreCase("desktop"))
            UI_actions.click_without_waiting(_calc_page.getBtn_clear());
    }

    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("api")) {
            auxiliary_methods.update_response_status_code(response.getStatusCode());
            verifications.number_value(integer, Integer.parseInt(get_data("StatusCode")), "Error in http requesting");
        }
    }

    @AfterClass
    public void closeSession() {
        manage_DB.close_DB_connection();
        if (!platform.equalsIgnoreCase("api"))
        {
            if(!platform.equalsIgnoreCase("mobile")) {
                if (!platform.equalsIgnoreCase("desktop"))
                    driver.quit();
                else windows_driver.quit();
            }
            else {
                mobile_driver.quit();
            }
        }
    }

}
