package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.AtmServer;
import support.KnowsTheAccount;
import support.KnowsTheCashSlot;

public class ServerHooks {

    public static final int PORT = 8887;

    private AtmServer server;
    private KnowsTheAccount helper;
    private KnowsTheCashSlot cashSlotHelper;

    public ServerHooks(KnowsTheAccount helper, KnowsTheCashSlot cashSlotHelper) {
        this.helper = helper;
        this.cashSlotHelper = cashSlotHelper;
    }

    @Before("@web")
    public void startServer() throws Exception {
        server = new AtmServer(PORT, cashSlotHelper.getCashSlot(), helper.getMyAccount());
        server.start();
    }

    @After("@web")
    public void stopServer() throws Exception {
        server.stop();
    }
}
