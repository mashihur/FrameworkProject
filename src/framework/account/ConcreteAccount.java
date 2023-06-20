package framework.account;

import framework.customer.ICustomer;

public class ConcreteAccount extends Account {
    private double INTEREST_RATE = 0.0;

    public ConcreteAccount(String accNumber, double balance, ICustomer customer) {
        super(accNumber, balance, customer);
    }

    @Override
    public void addInterest(double interest) {
        INTEREST_RATE += interest;
    }

    public double getINTEREST_RATE() {
        return INTEREST_RATE;
    }

}
