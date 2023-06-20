package bankingSystem;

import framework.Account;
import framework.ConcreteAccount;
import framework.IAccountFactory;
import framework.ICustomer;

public class BankAccountFactory implements IAccountFactory {
    @Override
    public Account createAccount(String accountType, String accNumber, double balance, ICustomer customer) {
        if (accountType.equals(BankConstants.CHECKING_ACCOUNT)) {
            return new CheckingAccount(accNumber, balance, customer);
        } else {
            return new SavingsAccount(accNumber, balance, customer);
        }
    }

}
