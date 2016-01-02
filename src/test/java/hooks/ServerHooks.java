package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.Account;
import nicebank.AtmServer;
import nicebank.CashSlot;

public class ServerHooks {

    public static final int PORT = 8887;

    private AtmServer server;
    private Account account;
    private CashSlot cashSlot;

    public ServerHooks(Account account, CashSlot cashSlot) {
        this.account = account;
        this.cashSlot = cashSlot;
    }

    @Before("@web")
    public void startServer() throws Exception {
        server = new AtmServer(PORT, cashSlot, account);
        server.start();
    }

    @After("@web")
    public void stopServer() throws Exception {
        server.stop();
    }
}
