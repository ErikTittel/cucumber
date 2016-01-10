package step_definitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.Fruit;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

@Singleton
public class TransformationSteps {

    private List<String> fruitNames;
    private List<Fruit> fruitList;
    private Fruit fruit;

    @Given("^the list of values: (.*)$")
    public void theListOfValues(List<String> words) {
        fruitNames = words;
    }

    @When("^I read the list$")
    public void iReadTheList() {
        // list already saved
    }

    @Then("^I should get: (.*)$")
    public void iShouldGet(List<String> expectedValues) {
        assertThat(fruitNames, is(expectedValues));
    }

    @Given("^I have a fruit with the following details$")
    public void iHaveAFruitWithTheFollowingDetails(@Transpose List<Fruit> fruitList) {
        this.fruit = fruitList.get(0);
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

    @Given("^I have the following list of fruit$")
    public void iHaveTheFollowingListOfFruit(List<Fruit> fruitList) {
        this.fruitList = new ArrayList<>(fruitList);
    }

    @When("^the fruit gains weight$")
    public void theFruitGainsWeight() {
        fruitList.forEach(Fruit::addWeight);
    }

    @Then("^the fruit match the following details$")
    public void theFruitMatchTheFollowingDetails(List<Fruit> fruitList) {
        assertThat(this.fruitList, is(fruitList));
    }

    private String text;

    @Given("^I have the following text$")
    public void iHaveTheFollowingText(String text) throws Throwable {
        this.text = text;
    }

    @When("^I process the text$")
    public void iProcessTheText() throws Throwable {
        text = text.replace("Hello", "World");
    }

    @Then("^it should be equals to the following$")
    public void itShouldBeEqualsToTheFollowing(String text) throws Throwable {
        assertThat(this.text, is(text));
    }
}
