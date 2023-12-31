package banking;

import framework.account.Account;
import framework.customer.ICustomer;

public class CheckingAccount extends Account  {
    private double INTEREST_RATE = 0.1;

    public CheckingAccount(String accNumber, double balance, ICustomer customer) {
        super(accNumber, balance, customer);

    }

    @Override
    public void addInterest(double interest) {
        balance += balance * INTEREST_RATE;
    }

    @Override
    public String getAccountType() {
        return "Ch";
    }

}
