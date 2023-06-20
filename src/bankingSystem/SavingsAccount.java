package bankingSystem;

import framework.account.Account;
import framework.account.IEntry;
import framework.customer.ICustomer;

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
        double totalWithdrawal = 0.0;
        double totalDeposit = 0.0;
        for (IEntry entry : entryList) {
            totalWithdrawal += entry.getWithdrawOrCharge();
            totalDeposit += entry.getDeposit();
        }

        StringBuilder recordBuilder = new StringBuilder();
        recordBuilder.append("Name: " + customer.getCustomerName() + "\n")
                .append("Account No: " + getAccountNumber() + "\n")
                .append("Previous balance: " + monthlyBalance.getStartingBalance() + "\n")
                .append("Total deposit: " + totalDeposit + "\n")
                .append("Total withdrawal: " + totalWithdrawal + "\n")
                .append("Current balance: " + balance + "\n");
        return null;
    }
}
