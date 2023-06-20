package framework;

import java.time.LocalDate;
import java.util.Date;

public abstract class Entry implements IEntry {
    private double amount;
    private LocalDate date;
    private String name;

    public Entry(double amount, LocalDate date, String name) {
        this.amount = amount;
        this.date = date;
        this.name = name;
    }

    @Override
    public Double getDeposit() {
        return 0.0;
    }

    @Override
    public Double getWithdrawOrCharge() {
        return 0.0;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
