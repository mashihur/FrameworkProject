package framework;

import java.time.LocalDate;

public class WithdrawEntry extends Entry {
    public WithdrawEntry(double amount, LocalDate date, String name) {
        super(amount, date, name);
    }

    @Override
    public Double getWithdrawOrCharge() {
        return getAmount();
    }
}
