package nicebank;

import static support.TestLayer.BACKEND;

import cucumber.api.java.en.When;
import support.KnowsTheDomain;

public class TellerSteps {

    private final KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        helper.getTeller(BACKEND).withdrawFrom(helper.getMyAccount(), dollars);
    }

}
