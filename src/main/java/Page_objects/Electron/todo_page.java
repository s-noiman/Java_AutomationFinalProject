package Page_objects.Electron;

import com.sun.deploy.config.WinPlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class todo_page {
    final String path = "body > div > div.transition_1AwoP > div.wrapper_DtvJU > div:nth-child(2) > div > div:nth-child(";

    @FindBy(css = "body > div > div.transition_1AwoP > div.wrapper_DtvJU > div:nth-child(2) > div > div > div")
    private List<WebElement> todos_list;

    public List<WebElement> getTodos_list() {
        return todos_list;
    }

    public WebElement get_todo(WebDriver driver, int index) {
        return driver.findElement(By.cssSelector(path  + index + ") > div > div > div > label"));
    }

    public WebElement get_delete_btn(WebDriver driver, int todoIndex) {
        return driver.findElement(By.cssSelector(path  + todoIndex + ") > div > div > svg"));
    }

    public WebElement get_todo_to_complete(WebDriver driver, int todoIndex) {
        return driver.findElement(By.cssSelector(path + todoIndex + ") > div > div > label > svg"));
    }

    public WebElement get_todo_to_doubleClick(WebDriver driver, int todoIndex) {
        return driver.findElement(By.cssSelector(path + todoIndex + ") > div > div > div"));
    }
    public WebElement get_todo_to_move(WebDriver driver, int todoIndex) {
        return driver.findElement(By.cssSelector(path + todoIndex + ") > div"));
    }
    public WebElement get_move_todo(WebDriver driver, int todoIndex) {
        return driver.findElement(By.cssSelector(path + todoIndex + ") > div > input"));
    }
    public WebElement get_completed_todo(WebDriver driver, int todoIndex) {
        return driver.findElement(By.cssSelector(path + todoIndex + ") > div > div > label > svg > path"));
    }



    public WebElement getInp_todos() {
        return inp_todos;
    }

    @FindBy(css = "div.wrapper_3Uk1J > input")
    private WebElement inp_todos;


}
