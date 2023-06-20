package framework;

import java.time.LocalDate;

public class MonthlyBalance {
    LocalDate month;
    private double startingBalance;

    public MonthlyBalance(LocalDate month, double startingBalance) {
        this.month = month;
        this.setStartingBalance(startingBalance);
    }

    public int getMonthValue() {
        return month.getMonthValue();
    }

    public double getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(double startingBalance) {
        this.startingBalance = startingBalance;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }
}
