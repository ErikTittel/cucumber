package nicebank;

public class TransactionProcessor {

    private TransactionQueue queue = new TransactionQueue();

    public void process() {
        boolean firstRound = true;
        do {
            String message = queue.read();

            if (message.length() > 0) {
                if (!firstRound) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                } else {
                    firstRound = false;
                }

                Money balance = BalanceStore.getBalance();
                Money transactionAmount = new Money(message);

                if (isCreditTransaction(message)) {
                    BalanceStore.setBalance(balance.add(transactionAmount));
                } else {
                    BalanceStore.setBalance(balance.minus(transactionAmount));
                }
            }
        } while (true);
    }

    private boolean isCreditTransaction(String message) {
        return !message.startsWith("-");
    }

}
