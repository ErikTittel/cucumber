package nicebank;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import support.KnowsTheAccount;
import support.KnowsTheCashSlot;
import transforms.MoneyConverter;

import java.util.function.Supplier;

public class AccountSteps {

    private final KnowsTheAccount helper;

    public AccountSteps(KnowsTheAccount helper) {
        this.helper = helper;
    }

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith$(@Transform(MoneyConverter.class) Money amount) {
        helper.getMyAccount().credit(amount);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws
            InterruptedException {
        assertThatEventuallyEqual(helper.getMyAccount()::getBalance, amount, 3000, 50);
    }

    private void assertThatEventuallyEqual(Supplier<?> supplier, Object expected, int timeoutMilliSecs, int
            pollIntervalMilliSecs) throws InterruptedException {
        while (!supplier.get().equals(expected) && timeoutMilliSecs > 0) {
            Thread.sleep(pollIntervalMilliSecs);
            timeoutMilliSecs -= pollIntervalMilliSecs;
        }
        assertThat(supplier.get(), is(expected));
    }

}
