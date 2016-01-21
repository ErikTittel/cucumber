package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.BalanceStore;
import nicebank.TransactionProcessor;
import nicebank.TransactionQueue;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AsyncHooks {

    private Thread transactionProcessorThread;

    @Before(value = "@async")
    public void startBackgroundThread() {
        transactionProcessorThread = new Thread() {
            @Override
            public void run() {
                TransactionProcessor processor = new TransactionProcessor();
                processor.process();
            }
        };
        transactionProcessorThread.start();
    }

    @Before(value = "@async", order = 10)
    public void reset() {
        TransactionQueue.clear();
        BalanceStore.clear();
    }

    @After(value = "@async")
    public void stopBackgroundThread() {
        transactionProcessorThread.interrupt();
    }

}
