package step_definitions;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import bank.Checkout;

import cucumber.api.java.en.*;

import java.util.Map;
import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CheckoutSteps {

    private Checkout checkout = new Checkout();
    private Map<String, Integer> prices = new HashMap<>();

    @Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
    public void thePriceOfAIsC(String name, int price) {
        prices.put(name, price);
    }

    @When("^I checkout (\\d+) \"([^\"]*)\"$")
    public void iCheckout(int itemCount, String itemName) {
        checkout.add(itemCount, prices.get(itemName));
    }

    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int total) {
        assertThat(checkout.total(), is(total));
    }
}
