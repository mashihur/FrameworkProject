package bankingSystem;

import framework.*;
import framework.account.IAccount;
import framework.customer.CustomerFactory;
import framework.customer.ICustomer;
import framework.customer.IPerson;

import java.time.LocalDate;
import java.util.function.BiPredicate;

import bankingSystem.ui.BankFrame;
import bankingSystem.ui.BankTableModel;
import framework.ui.FinCoFrame;

public class Bank extends FinCo {
    public static void main(String[] args) {
        FinCoFrame bankApp = new BankFrame(new Bank(), new BankTableModel());
        bankApp.setTitle("Bank Application");
        bankApp.setVisible(true);
    }

    @Override
    public IPerson createPersonalAccount(String accType, String accountNumber, double balance, LocalDate expDate, String name, String email, String street, String city, String state, String zip, String birthday) {
        IPerson person = new CustomerFactory().createPerson(name, email, street, city, state, zip, birthday);
        BiPredicate<Double, Double> emailSendingCondition = (resultingBalance, amount) -> resultingBalance < 0 || (amount > 600);
        person.setEmailSendingCondition(emailSendingCondition);
        addAccount(accType,person, accountNumber, balance, expDate);
        customerList.add(person);
        return person;
    }

    @Override
    public void addAccount(String accType, ICustomer customer, String accountNumber, double balance, LocalDate expDate) {
        IAccount account = new BankAccountFactory().createAccount(accType, accountNumber, balance, customer, expDate);
        customer.addAccount(account);
    }
}
