package bankingSystem;

import framework.*;

import java.util.function.BiPredicate;

public class Bank extends FinCo {

    @Override
    public IPerson createPersonalAccount(String accType, String accountNumber, double balance) {
        IPerson person = new CustomerFactory().createPerson();
        BiPredicate<Double, Double> emailSendingCondition = (resultingBalance, amount) -> resultingBalance < 0 || (amount > 600);
        person.setEmailSendingCondition(emailSendingCondition);
        addAccount(accType,person, accountNumber, balance);
        customerList.add(person);
        return person;
    }

    @Override
    public void addAccount(String accType, ICustomer customer, String accountNumber, double balance) {
        IAccount account = new BankAccountFactory().createAccount(accType, accountNumber, balance, customer);
        customer.addAccount(account);
    }
}
