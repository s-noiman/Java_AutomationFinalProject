package work_flows;

import Extenstions.UI_actions;
import Extenstions.verifications;
import Utilities.common_ops;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class electron_flows extends common_ops {

    @Step("Get several existing tasks")
    public static int countTodos() {
       return (_todo.getTodos_list()).size();
    }

    @Step("Get index of task")
    public static int getTodoIndex(String todoDescription) {
        int index = 1;
        while(index <= countTodos()) {
            if (compare((_todo.get_todo(driver, index)).getText(), todoDescription))
                return index;
            index++;
        }
        return 0;
    }

    @Step("Comparing a task to a string obtained as a parameter")
    private static boolean compare(String elem, String todoDesc) {
        return elem.compareTo(todoDesc) == 0;
    }

    @Step("Create tasks")
    public static void createAll(String... todoDescription) {
        for(String todo: todoDescription)
            createIt(todo);
    }

    @Step("Create task")
    private static void createIt(String todoDescription) {
        UI_actions.enter_action(_todo.getInp_todos(), todoDescription);
        integer++;
    }

    @Step("Delete tasks")
    public static void deleteAll(String... todoDescription) {
        for(String todo: todoDescription) {
            deleteIt(getTodoIndex(todo)); }
    }

    @Step("Delete task")
    private static void deleteIt(int todoIndex) {
        action.moveToElement(_todo.get_delete_btn(driver,todoIndex)).click().build().perform();
        integer--;
    }

    @Step("Change task")
    public static void change(int indexToChange, String changeValue) {
        UI_actions.double_click_action(UI_actions.move_to_element(_todo.get_todo_to_doubleClick(driver, indexToChange)));
        UI_actions.move_to_element(_todo.get_todo_to_move(driver, indexToChange));
        UI_actions.key_down_action("a");
        UI_actions.enter_action(UI_actions.move_to_element(_todo.get_move_todo(driver, indexToChange)), changeValue);
    }

    @Step("Mark a completed task")
    public static void complete(String todoDescription) {
        UI_actions.click_without_waiting(_todo.get_todo_to_complete(driver, getTodoIndex(todoDescription)));
    }


}
