package bankingSystem;

import framework.account.Account;
import framework.account.IAccountFactory;
import framework.customer.ICustomer;

import java.time.LocalDate;

public class BankAccountFactory implements IAccountFactory {
    @Override
    public Account createAccount(String accountType, String accNumber, double balance, ICustomer customer, String expDate) {
        if (accountType.equals(BankConstants.CHECKING_ACCOUNT)) {
            return new CheckingAccount(accNumber, balance, customer);
        } else {
            return new SavingsAccount(accNumber, balance, customer);
        }
    }

}
