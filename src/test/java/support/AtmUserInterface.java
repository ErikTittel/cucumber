package support;

import nicebank.Account;
import nicebank.AtmServer;
import nicebank.Teller;
import org.openqa.selenium.By;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AtmUserInterface implements Teller {

    @Inject
    private WebDriverHolder helper;

    @Override
    public void withdrawFrom(Account account, int dollars) {
        MyWebDriver webDriver = helper.getMyWebDriver();
        webDriver.get("http://localhost:" + AtmServer.PORT);
        webDriver.findElement(By.id("amount")).sendKeys(String.valueOf(dollars));
        webDriver.findElement(By.id("withdraw")).click();
    }

}
