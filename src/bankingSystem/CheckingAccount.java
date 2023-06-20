package bankingSystem;

import framework.account.Account;
import framework.account.IEntry;
import framework.customer.ICustomer;

import java.time.LocalDate;

public class CheckingAccount extends Account  {
    private double INTEREST_RATE = 0.0;

    public CheckingAccount(String accNumber, double balance, ICustomer customer) {
        super(accNumber, balance, customer);

    }

    @Override
    public void addInterest(double interest) {
        INTEREST_RATE += interest;
    }

}
