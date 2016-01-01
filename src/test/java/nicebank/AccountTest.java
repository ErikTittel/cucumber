package nicebank;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/cash_withdrawal.feature"},
        glue = {"nicebank", "hooks"},
        plugin = {"pretty", "html:target/cucumber"},
        snippets = SnippetType.CAMELCASE,
        strict = true)
public class AccountTest {

    @BeforeClass
    public static void setUpGlobal() {
        System.out.println("*********** Cucumber is about to start :-)");
    }

    @AfterClass
    public static void tearDownGlobal() {
        System.out.println("*********** Cucumber is about to end :-(");
    }
}