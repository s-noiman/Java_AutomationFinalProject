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

    @Step
    public static int countTodos() {
       return (_todo.getTodos_list()).size();
    }

    @Step
    public static int getTodoIndex(String todoDescription) {
        int index = 1;
        while(index <= countTodos()) {
            if (compare((_todo.get_todo(driver, index)).getText(), todoDescription))
                return index;
            index++;
        }
        return 0;
    }

    @Step
    private static boolean compare(String elem, String todoDesc) {
        return elem.compareTo(todoDesc) == 0;
    }

    @Step
    public static void createAll(String... todoDescription) {
        for(String todo: todoDescription)
            createIt(todo);
    }

    @Step
    private static void createIt(String todoDescription) {
        UI_actions.enter_action(_todo.getInp_todos(), todoDescription);
        todos++;
    }

    @Step
    public static void deleteAll(String... todoDescription) {
        for(String todo: todoDescription) {
            deleteIt(getTodoIndex(todo)); }
    }

    @Step
    private static void deleteIt(int todoIndex) {
        action.moveToElement(_todo.get_delete_btn(driver,todoIndex)).click().build().perform();
        todos--;
    }

    @Step
    public static void verifyTodos() {
        assertEquals(countTodos(), todos, "Expected amount");
    }

    @Step
    public static void verifyTodos(String todoDescription) {
        assertTrue(getTodoIndex(todoDescription) > 0);
    }

    @Step
    public static void change(int indexToChange, String changeValue) {
        UI_actions.double_click_action(UI_actions.move_to_element(_todo.get_todo_to_doubleClick(driver, indexToChange)));
        UI_actions.move_to_element(_todo.get_todo_to_move(driver, indexToChange));
        UI_actions.key_down_action("a");
        UI_actions.enter_action(UI_actions.move_to_element(_todo.get_move_todo(driver, indexToChange)), changeValue);
    }

    @Step
    public static void complete(String todoDescription) {
        UI_actions.click_without_waiting(_todo.get_todo_to_complete(driver, getTodoIndex(todoDescription)));
    }

    @Step
    public static void verifyCompleted(String todoDescription) {
        verifications.is_elem_exists_without_wait(_todo.get_completed_todo(driver, getTodoIndex(todoDescription)), true, "completed");
    }

}
