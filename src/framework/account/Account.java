package framework.account;

import framework.customer.Customer;
import framework.customer.ICustomer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount{
    protected String accNumber;
    protected double balance;
    protected ICustomer customer;
    protected List<IEntry> entryList = new ArrayList<>();
    protected MonthlyBalance monthlyBalance;

    public Account(String accNumber, double balance, ICustomer customer) {
        this.accNumber = accNumber;
        this.balance = balance;
        this.customer = customer;
        monthlyBalance = new MonthlyBalance(LocalDate.now(), balance);
    }


    @Override
    public void addEntry(IEntry entry) {
        entryList.add(entry);
    }

    @Override
    public void deposit(double amount) {
        monthlyBalance.update(LocalDate.now(), balance);
        balance += amount;
        addEntry(new DepositEntry(amount, LocalDate.now(), "Deposit"));
        customer.sendEmailToCustomer(balance, amount);
    }

    @Override
    public void withdrawOrCharge(double amount) {
        monthlyBalance.update(LocalDate.now(), balance);
        balance -= amount;
        addEntry(new WithdrawEntry(amount, LocalDate.now(), "Withdraw"));
        customer.sendEmailToCustomer(balance, amount);
    }


    @Override
    public String getAccountNumber() {
        return accNumber;
    }

    @Override
    public ICustomer getCustomer() {
        return this.customer;
    }

    @Override
    public String generateMonthlyRecord() {
        double totalWithdrawal = 0.0;
        double totalDeposit = 0.0;
        for (IEntry entry : entryList) {
            LocalDate entryDate = entry.getDate();
            LocalDate now = LocalDate.now();
            if (entryDate.getMonthValue() == now.getMonthValue() && entryDate.getMonthValue() == now.getMonthValue()) {
                totalWithdrawal += entry.getWithdrawOrCharge();
                totalDeposit += entry.getDeposit();
            }
        }

        StringBuilder recordBuilder = new StringBuilder();
        recordBuilder.append("Name: " + customer.getCustomerName() + "\n")
                .append("Account No: " + getAccountNumber() + "\n")
                .append("Previous balance: " + monthlyBalance.getStartingBalance() + "\n")
                .append("Total deposit: " + totalDeposit + "\n")
                .append("Total withdrawal: " + totalWithdrawal + "\n")
                .append("Current balance: " + balance + "\n");
        return recordBuilder.toString();
    }
}
