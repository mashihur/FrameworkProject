package framework.account;

import framework.customer.ICustomer;

import java.time.LocalDate;

public interface IAccountFactory {
    Account createAccount(String accountType, String accNumber, double balance, ICustomer customer, LocalDate expDate);
}
