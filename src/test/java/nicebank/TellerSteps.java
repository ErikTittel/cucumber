package nicebank;

import cucumber.api.java.en.When;

import javax.inject.Inject;

public class TellerSteps {

    private final Account account;
    private final Teller teller;

    @Inject
    // change AutomatedTeller to AtmUserInterface for testing throw web ui, and annotate the scenario with @web
    public TellerSteps(Account account, AutomatedTeller teller) {
        this.account = account;
        this.teller = teller;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        teller.withdrawFrom(account, dollars);
    }

}
