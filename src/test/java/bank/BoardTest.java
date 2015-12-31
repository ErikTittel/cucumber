package bank;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Erik
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/tic_tac_toe.feature"},
        glue = {"step_definitions"},
        plugin = {"progress", "html:target/cucumber"},
        snippets = SnippetType.CAMELCASE,
        strict = true)
public class BoardTest {

}
