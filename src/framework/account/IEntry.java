package framework.account;

import java.time.LocalDate;

public interface IEntry {
    Double getDeposit();
    Double getWithdrawOrCharge();
    LocalDate getDate();
}
