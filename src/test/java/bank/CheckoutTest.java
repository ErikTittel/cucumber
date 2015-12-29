package bank;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/checkout.feature"},
        glue = {"step_definitions"},
        plugin = {"progress", "html:target/cucumber"},
        snippets = SnippetType.CAMELCASE,
        strict = true)
public class CheckoutTest {

}