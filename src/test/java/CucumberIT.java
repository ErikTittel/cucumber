import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"nicebank", "hooks", "step_definitions"},
        tags = {"~@wip"},
        plugin = {"progress", "html:target/cucumber", "json:target/cucumber.json"},
        snippets = SnippetType.CAMELCASE,
        strict = false)
public class CucumberIT {
}
