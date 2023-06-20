package framework.account;

import java.time.LocalDate;

public class DepositEntry extends Entry {
    public DepositEntry(double amount, LocalDate date, String name) {
        super(amount, date, name);
    }

    @Override
    public Double getDeposit() {
        return getAmount();
    }
}
