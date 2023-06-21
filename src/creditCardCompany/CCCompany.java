package creditCardCompany;

import framework.*;
import framework.account.IAccount;
import framework.customer.CustomerFactory;
import framework.customer.ICustomer;
import framework.customer.IPerson;

import java.time.LocalDate;
import java.util.function.BiPredicate;

import creditCardCompany.ui.CreditCardFrame;

public class CCCompany extends FinCo {
    public static void main(String[] args) {
        CreditCardFrame ccardApp = new CreditCardFrame();
        ccardApp.setTitle("Credit Card Application");
        ccardApp.setVisible(true);
    }

    @Override
    public IPerson createPersonalAccount(String accType, String accountNumber, double balance, LocalDate expDate, String name, String email, String street, String city, String state, String zip, String birthday) {
        IPerson person = new CustomerFactory().createPerson(name, email, street, city, state, zip, birthday);
        BiPredicate<Double, Double> emailSendingCondition = (resultingBalance, amount) -> (amount > 600);
        person.setEmailSendingCondition(emailSendingCondition);
        addAccount(accType,person, accountNumber, balance, expDate);
        customerList.add(person);
        return person;
    }


    @Override
    public void addAccount(String accType, ICustomer customer, String accountNumber, double balance, LocalDate expDate) {
        IAccount account = new CreditAccountFactory().createAccount(accType, accountNumber, balance, customer, expDate);
        customer.addAccount(account);
    }
}
