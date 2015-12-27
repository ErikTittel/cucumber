package step_definitions;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import implementation.Checkout;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;

import java.util.Map;
import java.util.HashMap;

public class CheckoutSteps {

  private int bananaPrice = 0;
  private Checkout checkout = new Checkout();
  private Map<String, Integer> prices = new HashMap<>();

  @Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
  public void thePriceOfAIsC(String name, int price) throws Throwable {
	prices.put(name, price);
  }

  @When("^I checkout (\\d+) \"([^\"]*)\"$")
  public void iCheckout(int itemCount, String itemName) throws Throwable {
	checkout.add(itemCount, prices.get(itemName));
  }

  @Then("^the total price should be (\\d+)c$")
  public void theTotalPriceShouldBeC(int total) throws Throwable {
    assertThat(checkout.total(), is(total));
  }
}
