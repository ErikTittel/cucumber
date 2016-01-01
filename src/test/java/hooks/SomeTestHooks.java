package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author Erik
 */
public class SomeTestHooks {

    @Before(value = "@hooked", order = 10)
    public void beforeCallingScenario() {
        System.out.println("************** About to start the scenario.");
    }

    @After(value = "@hooked", order = 10)
    public void afterRunningScenario(Scenario scenario) {
        System.out.println("************* Just finished running scenario: " + scenario.getName() + ", " + scenario
                .getStatus());
    }

}
