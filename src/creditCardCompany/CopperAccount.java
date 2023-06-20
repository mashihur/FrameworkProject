package creditCardCompany;

import framework.account.Account;
import framework.customer.ICustomer;

public class CopperAccount extends Account  {
    private double MI = 0.20;
    private double MP = 0.24;

    public CopperAccount(String accNumber, double balance, ICustomer customer) {
        super(accNumber, balance, customer);
    }

    @Override
    public void addInterest(double interest) {
        MI += interest;
    }

    @Override
    public String generateMonthlyRecord() {
        return null;
    }
}
