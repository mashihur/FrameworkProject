package framework.customer;

import framework.account.IAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public abstract class Customer implements ICustomer {
    String name;
    String email;
    String street;
    String city;
    String state;
    String zip;
    BiPredicate<Double, Double> emailSendingCondition = (balance, amount) -> true;
    List<IAccount> accountList = new ArrayList<>();

    public Customer(String name, String email, String street, String city, String state, String zip) {
        this.name = name;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public void addAccount(IAccount account) {
        accountList.add(account);
    }

    public List<IAccount> getAccountList() {
        return accountList;
    }

    public void sendEmailToCustomer(Double balance, Double amount) {
        if (emailSendingCondition.test(balance, amount)) {
            System.out.println("Email sent to " + email);
        }
    }

    public void setEmailSendingCondition(BiPredicate<Double, Double> emailSendingCondition) {
        this.emailSendingCondition = emailSendingCondition;
    }

    @Override
    public String getCustomerName() {
        return name;
    }

    @Override
    public String getCityName() {
        return city;
    }

    @Override
    public void addInterest(double interest) {
        for (IAccount account : accountList) {
            account.addInterest(interest);
        }
    }

    @Override
    public String generateAccReport() {
        StringBuilder reportBuilder = new StringBuilder();
        for (IAccount account : accountList) {
            reportBuilder.append(account.generateMonthlyRecord());
        }
        return reportBuilder.toString();
    }
}
