package framework;

import framework.account.AccountFactory;
import framework.account.IAccount;
import framework.account.IAccountFactory;
import framework.customer.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import framework.ui.FinCoFrame;

public class FinCo {
    protected ICustomerFactory customerFactory;
    protected IAccountFactory accountFactory;

    public FinCo() {
        customerFactory = new CustomerFactory();
        accountFactory = new AccountFactory();
    }
    
    public static void main(String[] args) {
        (new FinCoFrame()).setVisible(true);
    }

    protected List<ICustomer> customerList = new ArrayList<>();

    public List<ICustomer> getCustomerList() {
        return customerList;
    }

    public ICustomer createPersonalAccount(String accType, String accountNumber, double balance, LocalDate expDate, String name, String email, String street, String city, String state, String zip, String birthday) {
        ICustomer person = customerFactory.createCustomer(Constants.PERSONAL_ACCOUNT,name, email, street, city, state, zip, birthday, 0);
        addAccount(accType,person, accountNumber, balance, expDate);
        customerList.add(person);
        return person;
    }

    public ICustomer createCompanyAccount(String accType, String accountNumber, double balance, LocalDate expDate, String name, String email, String street, String city, String state, String zip, int noOfEmployee) {
        ICustomer company = customerFactory.createCustomer(Constants.COMPANY_ACCOUNT,name, email, street, city, state, zip, null, noOfEmployee);
        addAccount(accType, company, accountNumber, balance, expDate);
        customerList.add(company);
        return company;
    }

    public void addAccount(String accountType, ICustomer customer, String accountNumber, double balance, LocalDate expDate) {
        IAccount account = accountFactory.createAccount(accountType, accountNumber, balance, customer, expDate);
        customer.addAccount(account);
    }

    public void deposit(double amount, IAccount account) {
        account.deposit(amount);
    }

    public void withdrawOrCharge(double amount, IAccount account) {
        account.withdrawOrCharge(amount);
    }

    public void addInterest(double interest) {
        for (ICustomer customer : customerList) {
            customer.addInterest(interest);
        }
    }

    public String generateAccountReport() {
        StringBuilder reportBuilder = new StringBuilder();
        for (ICustomer customer : customerList) {
            reportBuilder.append(customer.generateAccReport());
        }
        return reportBuilder.toString();
    }

    public ICustomer getCustomerByName(String name) {
        for (ICustomer customer: getCustomerList()) {
            if (customer.getCustomerName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public IAccount getAccountByAccountNumber(String accountNumber) {
        IAccount account = null;
        for (ICustomer customer : customerList) {
            for (IAccount lAccount : customer.getAccountList()) {
                if (lAccount.getAccountNumber().equals(accountNumber)) {
                    return lAccount;
                }
            }
        }
        return account;
    }


}
