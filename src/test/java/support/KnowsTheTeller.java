package support;

import static support.TestLayer.WEB;

import nicebank.AtmUserInterface;
import nicebank.AutomatedTeller;
import nicebank.Teller;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class KnowsTheTeller {

    private Teller teller;
    private KnowsTheCashSlot cashSlotHelper;
    private EventFiringWebDriver webDriver;

    public KnowsTheTeller(KnowsTheCashSlot cashSlotHelper) {
        this.cashSlotHelper = cashSlotHelper;
    }

    public Teller getTeller(TestLayer layer) {
        if (teller == null) {
            if (layer == WEB) {
                teller = new AtmUserInterface(new MyWebDriver());
            } else {
                teller = new AutomatedTeller(cashSlotHelper.getCashSlot());
            }
        }
        return teller;
    }

}
