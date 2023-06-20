package creditCardCompany;

import framework.account.Account;
import framework.account.IAccountFactory;
import framework.customer.ICustomer;

public class CreditAccountFactory implements IAccountFactory {
    @Override
    public Account createAccount(String accountType, String accNumber, double balance, ICustomer customer) {
        if (accountType.equals(CreditConstants.GOLD_ACCOUNT)) {
            return new GoldAccount(accNumber, balance, customer);
        } else if (accountType.equals(CreditConstants.SILVER_ACCOUNT)) {
            return new SilverAccount(accNumber, balance, customer);
        } else {
            return new CopperAccount(accNumber, balance, customer);
        }
    }

}
