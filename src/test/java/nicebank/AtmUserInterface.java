package nicebank;

import hooks.ServerHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AtmUserInterface implements Teller {

    private WebDriver webDriver;

    public AtmUserInterface(WebDriver webDriver) {
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
