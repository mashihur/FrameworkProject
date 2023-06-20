package framework.account;

import framework.customer.ICustomer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount{
    String accNumber;
    double balance;
    ICustomer customer;
    List<IEntry> entryList = new ArrayList<>();
    MonthlyBalance monthlyBalance;

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
        balance += amount;
        addEntry(new DepositEntry(amount, LocalDate.now(), "Deposit"));
        updateMonthlyBalance(LocalDate.now(), balance);
        customer.sendEmailToCustomer(balance, amount);
    }

    @Override
    public void withdrawOrCharge(double amount) {
        balance -= amount;
        addEntry(new WithdrawEntry(amount, LocalDate.now(), "Withdraw"));
        updateMonthlyBalance(LocalDate.now(), balance);
        customer.sendEmailToCustomer(balance, amount);
    }

    private void updateMonthlyBalance(LocalDate date, double balance) {
        if (date.getMonthValue() > monthlyBalance.getMonthValue()) {
            monthlyBalance.setStartingBalance(balance);
            monthlyBalance.setMonth(date);
        }
    }

    @Override
    public String getAccountNumber() {
        return accNumber;
    }
}
