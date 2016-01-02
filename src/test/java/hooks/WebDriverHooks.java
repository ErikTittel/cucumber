package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import support.MyWebDriver;

import javax.inject.Inject;

public class WebDriverHooks {

    @Inject
    private MyWebDriver webDriver;

    @After("@web")
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (Exception somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        } finally {
            webDriver.close();
        }
    }

}
