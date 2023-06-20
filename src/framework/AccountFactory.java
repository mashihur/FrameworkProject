package framework;

public class AccountFactory implements IAccountFactory {

    @Override
    public Account createAccount(String accountType, String accNumber, double balance, ICustomer customer) {
        return new ConcreteAccount(accNumber, balance, customer);
    }

}
