package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SomeTestHooks {

    @Before(value = "@simplelog", order = 10)
    public void beforeCallingScenario() {
        System.out.println("************** About to start the scenario.");
    }

    @After(value = "@simplelog", order = 10)
    public void afterRunningScenario(Scenario scenario) {
        System.out.println("************* Just finished running scenario: " + scenario.getName() + ", " + scenario
                .getStatus());
    }

}
