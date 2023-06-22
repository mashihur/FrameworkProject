package creditcard;

import framework.account.Account;
import framework.account.IAccountFactory;
import framework.customer.ICustomer;

import java.time.LocalDate;

public class CreditAccountFactory implements IAccountFactory {
    @Override
    public Account createAccount(String accountType, String accNumber, double balance, ICustomer customer, LocalDate expDate) {
        if (accountType.equals(CreditConstants.GOLD_ACCOUNT)) {
            return new GoldAccount(accNumber, balance, customer, expDate);
        } else if (accountType.equals(CreditConstants.SILVER_ACCOUNT)) {
            return new SilverAccount(accNumber, balance, customer, expDate);
        } else {
            return new CopperAccount(accNumber, balance, customer, expDate);
        }
    }

}
