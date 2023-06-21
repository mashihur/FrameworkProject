package framework;

import framework.account.AccountFactory;
import framework.account.IAccount;
import framework.customer.CustomerFactory;
import framework.customer.ICompany;
import framework.customer.ICustomer;
import framework.customer.IPerson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinCo {

    protected List<ICustomer> customerList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("hello world");
        FinCo finCo = new FinCo();
//        finCo.createPersonalAccount("A")
    }

    public IPerson createPersonalAccount(String accType, String accountNumber, double balance, String expDate, String name, String email, String street, String city, String state, String zip, String birthday) {
        IPerson person = new CustomerFactory().createPerson(name, email, street, city, state, zip, birthday);
        addAccount(accType,person, accountNumber, balance, expDate);
        customerList.add(person);
        return person;
    }

    public ICompany createCompanyAccount(String accType, String accountNumber, double balance, String expDate, String name, String email, String street, String city, String state, String zip, int noOfEmployee) {
        ICompany company = new CustomerFactory().createCompany(name, email, street, city, state, zip, noOfEmployee);
        addAccount(accType, company, accountNumber, balance, expDate);
        customerList.add(company);
        return company;
    }

    public void addAccount(String accountType, ICustomer customer, String accountNumber, double balance, String expDate) {
        IAccount account = new AccountFactory().createAccount(accountType, accountNumber, balance, customer, expDate);
        customer.addAccount(account);
    }

    public void depositMoney(double amount, IAccount account) {
        account.deposit(amount);
    }

    public void withdrawOrChargeMoney(double amount, IAccount account) {
        account.withdrawOrCharge(amount);
    }

    public void addInterest(double interest) {
        for (ICustomer customer : customerList) {
            for (IAccount account : customer.getAccountList()) {
                account.addInterest(interest);
            }
        }
    }

    public String generateAccountReport() {
        StringBuilder reportBuilder = new StringBuilder();
        for (ICustomer customer : customerList) {
            for (IAccount account : customer.getAccountList()) {
                reportBuilder.append(account.generateMonthlyRecord());
            }
        }
        return reportBuilder.toString();
    }

}
