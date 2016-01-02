package nicebank;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.java.en.Then;

public class CashSlotSteps {

    private final CashSlot cashSlot;

    public CashSlotSteps(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        assertThat(cashSlot.contents(), is(dollars));
    }
}
