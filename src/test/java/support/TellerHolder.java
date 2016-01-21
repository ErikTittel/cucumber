package support;

import nicebank.AutomatedTeller;
import nicebank.Teller;

import javax.inject.Inject;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TellerHolder {

    @Inject
    private AtmUserInterface atmUserInterface;
    @Inject
    private AutomatedTeller automatedTeller;

    private boolean isWeb = false;

    public void setWeb(boolean web) {
        isWeb = web;
    }

    public Teller getTeller() {
        if (isWeb) {
            return atmUserInterface;
        } else {
            return automatedTeller;
        }
    }
}
