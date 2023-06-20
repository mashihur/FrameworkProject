package bankingSystem;

import framework.Account;
import framework.ICustomer;

public class SavingsAccount extends Account {
    private double INTEREST_RATE = 0.0;

    public SavingsAccount(String accNumber, double balance, ICustomer customer) {
        super(accNumber, balance, customer);
    }

    @Override
    public void addInterest(double interest) {
        INTEREST_RATE += interest;
    }

    @Override
    public String generateMonthlyRecord() {
        return null;
    }
}