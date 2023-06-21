package framework.customer;

import framework.account.IAccount;

import java.util.List;
import java.util.function.BiPredicate;

public interface ICustomer {
    void addAccount(IAccount account);
    void sendEmailToCustomer(Double balance, Double amount);
    void setEmailSendingCondition(BiPredicate<Double,Double> predicate);
    List<IAccount> getAccountList();
    String getCustomerName();
    void addInterest(double interest);
    String generateAccReport();
}
