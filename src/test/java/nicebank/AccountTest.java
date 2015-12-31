package nicebank;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/cash_withdrawal.feature"},
        glue = {"nicebank"},
        plugin = {"pretty", "html:target/cucumber"},
        snippets = SnippetType.CAMELCASE,
        strict = true)
public class AccountTest {

}