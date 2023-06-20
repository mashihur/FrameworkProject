package creditCardCompany;

import framework.account.Account;
import framework.customer.ICustomer;

public class SilverAccount extends Account  {
    private double MI = 0.16;
    private double MP = 0.18;

    public SilverAccount(String accNumber, double balance, ICustomer customer) {
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
