package creditCardCompany;

import framework.account.Account;
import framework.account.DepositEntry;
import framework.account.IEntry;
import framework.customer.ICustomer;

import java.time.LocalDate;

public class CopperAccount extends Account  {
    private double MI = 0.20;
    private double MP = 0.24;
    private LocalDate expDate;

    public CopperAccount(String accNumber, double balance, ICustomer customer, LocalDate expDate) {
        super(accNumber, balance, customer);
        this.expDate = expDate;
    }

    @Override
    public void addInterest(double interest) {
        MI += interest;
    }

    @Override
    public void deposit(double amount) {
        monthlyBalance.update(LocalDate.now(), balance);
        balance += amount;
        addEntry(new DepositEntry(amount, LocalDate.now(), "Deposit"));
    }

    @Override
    public String getAccountType() {
        return "C";
    }

    @Override
    public String generateMonthlyRecord() {
        double totalCharges = 0.0;
        double totalCredits = 0.0;
        for (IEntry entry : entryList) {
            LocalDate entryDate = entry.getDate();
            LocalDate now = LocalDate.now();
            if (entryDate.getMonthValue() == now.getMonthValue() && entryDate.getMonthValue() == now.getMonthValue()) {
                totalCharges += entry.getWithdrawOrCharge();
                totalCredits += entry.getDeposit();
            }
        }
        double newBalance = monthlyBalance.getStartingBalance() - totalCredits + totalCharges + MI * (monthlyBalance.getStartingBalance() - totalCredits);
        double totalDue = MP * newBalance;

        StringBuilder recordBuilder = new StringBuilder();
        recordBuilder.append("Name: " + customer.getCustomerName() + "\n")
                .append("Account No: " + getAccountNumber() + "\n")
                .append("Previous balance: " + monthlyBalance.getStartingBalance() + "\n")
                .append("Total charges: " + totalCharges + "\n")
                .append("Total credits: " + totalCredits + "\n")
                .append("New balance: " + newBalance + "\n")
                .append("Total Due: " + totalDue + "\n");
        return recordBuilder.toString();
    }
}
