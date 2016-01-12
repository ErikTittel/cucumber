package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.Set;

import javax.inject.Singleton;

@Singleton
public class MyWebDriver implements WebDriver {

    // requires Selenium 2.41.0 and Firefox 28.0
    private EventFiringWebDriver delegate;

    public EventFiringWebDriver getDelegate() {
        if (delegate == null) {
            delegate = new EventFiringWebDriver(new FirefoxDriver());
        }
        return delegate;
    }

    @Override
    public void get(String url) {
        getDelegate().get(url);
    }

    @Override
    public String getCurrentUrl() {
        return getDelegate().getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return getDelegate().getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getDelegate().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getDelegate().findElement(by);
    }

    @Override
    public String getPageSource() {
        return getDelegate().getPageSource();
    }

    @Override
    public void close() {
        getDelegate().close();
    }

    @Override
    public void quit() {
        getDelegate().quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return getDelegate().getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return getDelegate().getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return getDelegate().switchTo();
    }

    @Override
    public Navigation navigate() {
        return getDelegate().navigate();
    }

    @Override
    public Options manage() {
        return getDelegate().manage();
    }
}
