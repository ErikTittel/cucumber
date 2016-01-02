package support;

import nicebank.Account;

public class KnowsTheAccount {

    private Account myAccount;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }
        return myAccount;
    }
}
