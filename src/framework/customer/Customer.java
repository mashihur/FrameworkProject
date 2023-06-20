package framework.customer;

import framework.account.IAccount;

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
    List<IAccount> accountList;

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

    public  void setEmailSendingCondition(BiPredicate<Double, Double> emailSendingCondition) {
        this.emailSendingCondition = emailSendingCondition;
    }

    @Override
    public String getCustomerName() {
        return name;
    }

}
