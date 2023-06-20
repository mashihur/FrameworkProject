package creditCardCompany;

import framework.*;
import framework.account.IAccount;
import framework.customer.CustomerFactory;
import framework.customer.ICustomer;
import framework.customer.IPerson;

import java.util.function.BiPredicate;

public class CCCompany extends FinCo {

    @Override
    public IPerson createPersonalAccount(String accType, String accountNumber, double balance) {
        IPerson person = new CustomerFactory().createPerson();
        BiPredicate<Double, Double> emailSendingCondition = (resultingBalance, amount) -> (amount > 600);
        person.setEmailSendingCondition(emailSendingCondition);
        addAccount(accType,person, accountNumber, balance);
        customerList.add(person);
        return person;
    }

    @Override
    public void addAccount(String accType, ICustomer customer, String accountNumber, double balance) {
        IAccount account = new CreditAccountFactory().createAccount(accType, accountNumber, balance, customer);
        customer.addAccount(account);
    }
}
