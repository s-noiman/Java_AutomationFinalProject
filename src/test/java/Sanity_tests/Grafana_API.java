package Sanity_tests;

import Utilities.common_ops;
import org.testng.annotations.Test;
import work_flows.API_flows;
import Extenstions.verifications;

public class Grafana_API extends common_ops {

    @Test
    public void Get_request() {
        API_flows.get_user_by_login_or_email(user_name);
    }

    @Test
    public void PUT_request() {
        API_flows.change_password("admin");
    }

    @Test
    public void POST_request() {
        API_flows.switch_user_context_for_signed_in_user(1);
    }
}