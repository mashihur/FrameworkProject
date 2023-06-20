package creditCardCompany;

import framework.Account;
import framework.ICustomer;

public class GoldAccount extends Account  {
    private double MI = 0.12;
    private double MP = 0.12;

    public GoldAccount(String accNumber, double balance, ICustomer customer) {
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
