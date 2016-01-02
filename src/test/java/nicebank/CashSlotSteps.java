package nicebank;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.java.en.Then;
import support.KnowsTheCashSlot;

public class CashSlotSteps {

    private final KnowsTheCashSlot helper;

    public CashSlotSteps(KnowsTheCashSlot helper) {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        assertThat(helper.getCashSlot().contents(), is(dollars));
    }
}
