package nicebank;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AutomatedTeller implements Teller {

    @Inject
    private CashSlot cashSlot;

    @Override
    public void withdrawFrom(Account account, int dollars) {
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }
}
