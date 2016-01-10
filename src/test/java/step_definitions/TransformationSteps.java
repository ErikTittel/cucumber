package step_definitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.Fruit;

import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

@Singleton
public class TransformationSteps {

    private List<String> fruitList;
    private Fruit fruit;

    @Given("^the list of values: (.*)$")
    public void theListOfValues(List<String> stringList) {
        this.fruitList = stringList;
    }

    @When("^I read the list$")
    public void iReadTheList() {
        // list already saved
    }

    @Then("^I should get: (.*)$")
    public void iShouldGet(List<String> expectedFruit) {
        assertThat(fruitList, is(expectedFruit));
    }

    @Given("^I have a fruit with the following details$")
    public void iHaveAFruitWithTheFollowingDetails(Map<String, String> fruitDescription) {
        this.fruit = Fruit.createFruit(fruitDescription);
    }

    @When("^the fruit becomes ripe$")
    public void theFruitBecomesRipe() {
        fruit.setColour("red");
    }

    @Then("^the (\\w*) is (\\w*)\\.$")
    public void theAttributeIsValue(String attribute, String expectedValue) {
        Object actualValue = fruit.getValue(attribute);
        assertThat(actualValue, is(expectedValue));
    }
}
