package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import support.TellerHolder;
import support.WebDriverHolder;

import javax.inject.Inject;

public class WebDriverHooks {

    @Inject
    private TellerHolder tellerHolder;

    @Inject
    private WebDriverHolder helper;

    @Before("@web")
    public void setWebTeller() {
        tellerHolder.setWeb(true);
    }

    @After("@web")
    public void finish(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = helper.getMyWebDriver().getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } catch (Exception somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        } finally {
            helper.getMyWebDriver().close();
        }
    }

}
