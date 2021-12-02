package work_flows;

import Extenstions.UI_actions;
import Extenstions.verifications;
import Utilities.common_ops;
import io.qameta.allure.Step;

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
    public static void change(int indexToChange) {
        UI_actions.double_click_action(UI_actions.move_to_element(_todo.get_todo_to_doubleClick(driver, indexToChange)));
        UI_actions.move_to_element(_todo.get_todo_to_move(driver, indexToChange));
        UI_actions.key_down_action("a");
        UI_actions.enter_action(UI_actions.move_to_element(_todo.get_move_todo(driver, indexToChange)), str);
    }

    @Step("Mark a completed task")
    public static void complete() {
        UI_actions.click_without_waiting(_todo.get_todo_to_complete(driver, getTodoIndex(str)));
    }

    @Step("Verify amount of tasks")
    public static void verify_tasks_amount() {
        verifications.number_value(electron_flows.countTodos(), integer, "Unexpected tasks amount");
    }

    @Step("Verify task was changed")
    public static void verify_tasks_changed(boolean expected_result, String massage) {
        verifications.verify_condition(expected_result,electron_flows.getTodoIndex(str) > 0, massage);
    }

    @Step("Verify task was changed")
    public static void verify_task_completed(boolean expected_result, String massage) {
        verifications.is_elem_exists_without_wait(_todo.get_completed_todo(driver, electron_flows.getTodoIndex(str)), expected_result, massage);
    }


}
