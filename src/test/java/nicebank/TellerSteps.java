package nicebank;

import cucumber.api.java.en.When;
import support.TellerHolder;

import javax.inject.Inject;

public class TellerSteps {

    @Inject
    private Account account;

    @Inject
    private TellerHolder tellerHolder;

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        tellerHolder.getTeller().withdrawFrom(account, dollars);
    }

}
