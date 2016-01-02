package support;

import static support.TestLayer.WEB;

import nicebank.Account;
import nicebank.AtmUserInterface;
import nicebank.AutomatedTeller;
import nicebank.CashSlot;
import nicebank.Teller;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class KnowsTheDomain {

    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;
    private EventFiringWebDriver webDriver;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }
        return myAccount;
    }
    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }

    public Teller getTeller(TestLayer layer) {
        if (teller == null) {
            if (layer == WEB) {
                teller = new AtmUserInterface(getWebDriver());
            } else {
                teller = new AutomatedTeller(getCashSlot());
            }
        }
        return teller;
    }

    public EventFiringWebDriver getWebDriver() {
        if (webDriver == null) {
            // requires Selenium 2.41.0 and Firefox 28.0
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }
        return webDriver;
    }
}
