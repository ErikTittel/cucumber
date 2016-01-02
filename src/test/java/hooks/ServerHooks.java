package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.Account;
import nicebank.AtmServer;
import nicebank.CashSlot;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServerHooks {

    @Inject
    private AtmServer server;
    @Inject
    private Account account;
    @Inject
    private CashSlot cashSlot;

    @Before("@web")
    public void startServer() throws Exception {
        server.start();
    }

    @After("@web")
    public void stopServer() throws Exception {
        server.stop();
    }
}
