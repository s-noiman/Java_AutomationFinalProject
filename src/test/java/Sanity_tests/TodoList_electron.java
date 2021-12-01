package Sanity_tests;

import Utilities.common_ops;
import org.testng.annotations.Test;
import work_flows.electron_flows;

public class TodoList_electron extends common_ops {

    @Test
    public void test01_create() {
        electron_flows.createAll("Wake up", "Smile to world", "BlahBlah");
        electron_flows.verifyTodos();
    }

    @Test
    public void test02_Delete() {
        electron_flows.deleteAll("BlahBlah");
        electron_flows.verifyTodos();
    }

    @Test
    public void test03_change() {
        electron_flows.change(1, "Smile to world:)");
        electron_flows.verifyTodos("Smile to world:)");
    }

    @Test
    public void test04_completed() {
        electron_flows.complete("Wake up");
        electron_flows.verifyCompleted("Wake up");
    }

}
