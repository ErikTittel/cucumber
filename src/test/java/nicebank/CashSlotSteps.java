package nicebank;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.java.en.Then;
import support.KnowsTheDomain;

/**
 * @author Erik
 */
public class CashSlotSteps {

    private final KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        assertThat(helper.getCashSlot().contents(), is(dollars));
    }
}
