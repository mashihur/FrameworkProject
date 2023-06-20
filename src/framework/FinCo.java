package framework;

import java.util.ArrayList;
import java.util.List;

public class FinCo {

    protected List<ICustomer> customerList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public IPerson createPersonalAccount(String accType, String accountNumber, double balance) {
        IPerson person = new CustomerFactory().createPerson();
        addAccount(accType,person, accountNumber, balance);
        customerList.add(person);
        return person;
    }

    public ICompany createCompanyAccount(String accType, String accountNumber, double balance) {
        ICompany company = new CustomerFactory().createCompany();
        addAccount(accType, company, accountNumber, balance);
        customerList.add(company);
        return company;
    }

    public void addAccount(String accountType, ICustomer customer, String accountNumber, double balance) {
        IAccount account = new AccountFactory().createAccount(accountType, accountNumber, balance, customer);
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
