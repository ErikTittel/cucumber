package step_definitions;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import implementation.Checkout;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;

public class CheckoutSteps {

  int bananaPrice = 0;
  Checkout checkout;

  @Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
  public void thePriceOfAIsC(String name, int price) throws Throwable {
    bananaPrice = price;
  }

  @When("^I checkout (\\d+) \"([^\"]*)\"$")
  public void iCheckout(int itemCount, String itemName) throws Throwable {
    checkout = new Checkout();
	checkout.add(itemCount, bananaPrice);
  }

  @Then("^the total price should be (\\d+)c$")
  public void theTotalPriceShouldBeC(int total) throws Throwable {
    assertThat(checkout.total(), is(total));
  }
}
