package framework;

public interface IAccountFactory {
    Account createAccount(String accountType, String accNumber, double balance, ICustomer customer);
}
