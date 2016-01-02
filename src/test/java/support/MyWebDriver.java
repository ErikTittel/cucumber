package support;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyWebDriver extends EventFiringWebDriver {

    public MyWebDriver() {
        // requires Selenium 2.41.0 and Firefox 28.0
        super(new FirefoxDriver());
    }

}
