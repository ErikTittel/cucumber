package nicebank;

import cucumber.api.java.en.When;
import support.AtmUserInterface;

import javax.inject.Inject;

public class TellerSteps {

    @Inject
    private Account account;

    // change AutomatedTeller to AtmUserInterface for testing throw web ui, and annotate the scenario with @web
    @Inject
    private AutomatedTeller teller;

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        teller.withdrawFrom(account, dollars);
    }

}
