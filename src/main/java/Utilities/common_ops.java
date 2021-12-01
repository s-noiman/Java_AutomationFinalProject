package Utilities;

import Extenstions.UI_actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class common_ops extends base {

    public static String get_data(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try
        {
            fXmlFile = new File("./Configuration/Data_config.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML file: " + e);
        }
        finally
        {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public static void init_browser(String browserType) {
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
        driver.get(get_data("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(get_data("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(get_data("Timeout")));
        action = new Actions(driver);
    }

    public static WebDriver init_Chrome_driver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver init_FF_driver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver init_IE_driver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver init_Edge_driver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    public static void init_API() {
        RestAssured.baseURI = get_data("Grafana_API_URL");
        http_request = RestAssured.given();
    }

//    public static void init_Mobile() {
//        desired_capabilities.setCapability(MobileCapabilityType.UDID, get_data("UDID"));
//        desired_capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, get_data("APP_PACKAGE"));
//        desired_capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, get_data("APP_ACTIVITY"));
//        try
//        {
//            mobileDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desired_capabilities);
//        }
//        catch (Exception e)
//        {
//            System.out.println("Cannot connect to appium server, see details: " + e);
//        }
//        wait = new WebDriverWait(mobileDriver, Long.parseLong(get_data("Timeout")));
//        manage_pages.init_app();
//    }


    @BeforeClass
//    @Parameters({"PlatformName"})String PlatformName
    public void startSession() {
//        platform = PlatformName;
        platform = "web";
        if (platform.equalsIgnoreCase("web"))
            init_browser(get_data("BrowserName"));
        else if(platform.equalsIgnoreCase("mobile")) {
//            init_Mobile();
        }
        else if(platform.equalsIgnoreCase("api"))
            init_API();
        else
            throw new RuntimeException(("Invalid platform name stated"));
        manage_pages.init();
        manage_DB.init_DB_connection(get_data("DBURL"), get_data("DBUserName"), get_data("DBPassword"));
    }

    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web"))
            driver.get(get_data("url"));
        else if(platform.equalsIgnoreCase("mobile")) {
//            work_flows.mobileFlows.backToHomePage();
        }
    }

    @AfterClass
    public void closeSession() {
        manage_DB.close_DB_connection();
        if (!platform.equalsIgnoreCase("api"))
        {
            if(!platform.equalsIgnoreCase("mobile")) {
                UI_actions.click(_personal_area.darkThemeBtn);
                UI_actions.click(_personal_area.saveChangesBtn);
                driver.quit();
            }
            else {
//                mobileDriver.quit();
            }
        }
    }
}
