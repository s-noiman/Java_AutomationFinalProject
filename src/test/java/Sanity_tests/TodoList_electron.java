package Sanity_tests;

import Utilities.common_ops;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import work_flows.electron_flows;


public class TodoList_electron extends common_ops {

    @Test(priority = 0, description = "Test01: Create task")
    @Description("Test description: test creating tasks.")
    public void Create() {
        electron_flows.createAll("Wake up", "Smile to world", "BlahBlah");
        electron_flows.verify_tasks_amount();
    }

    @Test(priority = 1, description = "Test02: Delete task")
    @Description("Test description: test deleting tasks.")
    public void Delete() {
        electron_flows.deleteAll("BlahBlah");
        electron_flows.verify_tasks_amount();
    }

    @Test(priority = 2, description = "Test03: Change task")
    @Description("Test description: test changing tasks.")
    public void Change() {
        str = "Smile to world:)";
        electron_flows.change(1);
        electron_flows.verify_tasks_changed(true, "Teak did not changed");
    }

    @Test(priority = 3, description = "Test04: Completed task")
    @Description("Test description: test completed tasks.")
    public void Completed() {
        str = "Wake up";
        electron_flows.complete();
        electron_flows.verify_task_completed(true, "Task completion did not work as expected.");
    }

}
