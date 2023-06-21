package bankingSystem;

import framework.*;
import framework.account.IAccount;
import framework.customer.CustomerFactory;
import framework.customer.ICustomer;

import java.time.LocalDate;
import java.util.function.BiPredicate;

import bankingSystem.ui.BankFrame;

public class Bank extends FinCo {

    public Bank() {
        customerFactory = new CustomerFactory();
        accountFactory = new BankAccountFactory();
    }

    public static void main(String[] args) {
        BankFrame bankApp = new BankFrame();
        bankApp.setTitle("Bank Application");
        bankApp.setVisible(true);
    }

    @Override
    public IAccount createPersonalAccount(String accType, String accountNumber, double balance, LocalDate expDate,
            String name, String email, String street, String city, String state, String zip, String birthday) {
        ICustomer person = customerFactory.createCustomer(Constants.PERSONAL_ACCOUNT, name, email, street, city, state,
                zip, birthday, 0);
        BiPredicate<Double, Double> emailSendingCondition = (resultingBalance, amount) -> resultingBalance < 0
                || (amount > 600);
        person.setEmailSendingCondition(emailSendingCondition);
        IAccount newAccount = addAccount(accType, person, accountNumber, balance, expDate);
        customerList.add(person);
        return newAccount;
    }

    @Override
    public IAccount createCompanyAccount(String accType, String accountNumber, double balance, LocalDate expDate,
            String name, String email, String street, String city, String state, String zip, int noOfEmployee) {
        ICustomer company = customerFactory.createCustomer(Constants.COMPANY_ACCOUNT, name, email, street, city, state,
                zip, null, noOfEmployee);
        IAccount newAccount = addAccount(accType, company, accountNumber, balance, expDate);
        customerList.add(company);
        return newAccount;
    }

    @Override
    public IAccount addAccount(String accType, ICustomer customer, String accountNumber, double balance,
            LocalDate expDate) {
        IAccount account = accountFactory.createAccount(accType, accountNumber, balance, customer, expDate);
        customer.addAccount(account);
        return account;
    }
}
