package nicebank;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AutomatedTeller implements Teller {

    private CashSlot cashSlot;

    @Inject
    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Override
    public void withdrawFrom(Account account, int dollars) {
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }
}
