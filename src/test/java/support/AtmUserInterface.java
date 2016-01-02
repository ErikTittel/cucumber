package support;

import hooks.ServerHooks;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AtmUserInterface implements Teller {

    private MyWebDriver webDriver;

    @Inject
    public AtmUserInterface(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void withdrawFrom(Account account, int dollars) {
        try {
            webDriver.get("http://localhost:" + ServerHooks.PORT);
            webDriver.findElement(By.id("amount")).sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("withdraw")).click();
        } finally {
            webDriver.close();
        }
    }

}
