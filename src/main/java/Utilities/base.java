package Utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.windows.WindowsDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class base {

    // General
    protected static int integer;
    protected static String str;
    protected static List<String> str_list;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static String http_request_url, platform;
    protected static SoftAssert soft_assert;
    protected static Screen screen;
    protected static DesiredCapabilities desired_capabilities;
    protected static final String white_hex_color = "#ffffff";

    protected static AndroidDriver<AndroidElement> mobile_driver;
    protected static TouchAction touch_action;

    protected static WindowsDriver windows_driver;

    protected static ChromeOptions opt;

    // DB
    protected static Connection connection;
    protected static Statement stmt;
    protected static ResultSet rs;

    // Rest API
    protected static RequestSpecification http_request;
    protected static Response response;
    protected static JSONObject params = new JSONObject();

    //Web page objects
    protected static Page_objects.Web.login_page _login;
    protected static Page_objects.Web.password_page _password;
    protected static Page_objects.Web.personal_area_page _personal_area;

    //Mobile page objects
    protected static Page_objects.Mobile.Main_page _main_page;

    //Desktop page objects
    protected static Page_objects.Desktop.Calculator_page _calc_page;

    //Electron page objects
    protected static Page_objects.Electron.todo_page _todo;
}
