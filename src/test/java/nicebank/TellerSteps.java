package nicebank;

import cucumber.api.java.en.When;
import support.KnowsTheDomain;

/**
 * @author Erik
 */
public class TellerSteps {

    private final KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(int dollars) throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
    }

}
