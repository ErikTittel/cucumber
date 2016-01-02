package nicebank;

import static support.TestLayer.BACKEND;

import cucumber.api.java.en.When;
import support.KnowsTheAccount;
import support.KnowsTheTeller;

public class TellerSteps {

    private final KnowsTheAccount accountHelper;
    private final KnowsTheTeller tellerHelper;

    public TellerSteps(KnowsTheAccount accountHelper, KnowsTheTeller tellerHelper) {
        this.accountHelper = accountHelper;
        this.tellerHelper = tellerHelper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        tellerHelper.getTeller(BACKEND).withdrawFrom(accountHelper.getMyAccount(), dollars);
    }

}
