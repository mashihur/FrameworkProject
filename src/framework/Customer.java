package framework;

import java.util.List;
import java.util.function.BiPredicate;

public abstract class Customer {
    String name;
    String email;
    String street;
    String city;
    String state;
    String zip;
    BiPredicate<Double, Double> emailSendingCondition = (a,b) -> true;
    List<Account> accountList;

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void sendEmailToCustomer(Double balance, Double amount) {
        if (emailSendingCondition.test(balance, amount)) {
            sendEmail();
        }
    }
    abstract void sendEmail();


}
