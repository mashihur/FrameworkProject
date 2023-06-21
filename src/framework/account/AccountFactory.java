package framework.account;

import framework.customer.ICustomer;

import java.time.LocalDate;

public class AccountFactory implements IAccountFactory {

    @Override
    public Account createAccount(String accountType, String accNumber, double balance, ICustomer customer, LocalDate expDate) {
        return new ConcreteAccount(accNumber, balance, customer);
    }

}
