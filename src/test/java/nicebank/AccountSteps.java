package nicebank;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

/**
 * @author Erik
 */
public class AccountSteps {

    private final KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount) {
        helper.getMyAccount().deposit(amount);

        assertThat(helper.getMyAccount().getBalance(), is(amount));
    }

}
