package support;

import nicebank.AutomatedTeller;
import nicebank.Teller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
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
