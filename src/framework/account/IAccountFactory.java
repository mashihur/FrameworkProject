package framework.account;

import framework.customer.ICustomer;

public interface IAccountFactory {
    Account createAccount(String accountType, String accNumber, double balance, ICustomer customer);
}
