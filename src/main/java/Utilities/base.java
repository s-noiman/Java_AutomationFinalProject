package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class base {

    // General
    protected static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    protected final static String user_name = "admin", password = "admin";
    protected static String url, http_request_url, platform;
    protected static String authorization_basic_key = "Basic YWRtaW46YWRtaW4=";
    protected static SoftAssert soft_assert;
    public static Screenshot image_screenShot;
    public static ImageDiffer img_diff = new ImageDiffer();
    public static ImageDiff diff;
    public static Screen screen = new Screen();

    public static AppiumDriver mobile_driver;
    public static TouchAction t;
    public static DesiredCapabilities desired_capabilities = new DesiredCapabilities();

    public static Connection connection;
    public static Statement stmt;
    public static ResultSet rs;

    // Rest API
    protected static RequestSpecification http_request;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static int http_request_status_code;
    protected static JsonPath jp;

    //Web page objects
    protected static Page_objects.Web.login_page _login;
    protected static Page_objects.Web.password_page _password;
    protected static Page_objects.Web.personal_area_page _personal_area;

    //Mobile page objects
    protected static Page_objects.Mobile.Main_page _main_page;



}
