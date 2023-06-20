package framework;

public class ConcreteAccount extends Account {
    private double INTEREST_RATE = 0.0;

    public ConcreteAccount(String accNumber, double balance, ICustomer customer) {
        super(accNumber, balance, customer);
    }

    @Override
    public void addInterest(double interest) {
        INTEREST_RATE += interest;
    }

    public double getINTEREST_RATE() {
        return INTEREST_RATE;
    }

    @Override
    public String generateMonthlyRecord() {
        double totalWithdrawal = 0.0;
        double totalDeposit = 0.0;
        for (IEntry entry : entryList) {
            totalWithdrawal += entry.getWithdrawOrCharge();
            totalDeposit += entry.getDeposit();
        }

        StringBuilder recordBuilder = new StringBuilder();
        recordBuilder.append("Name: " + customer.getCustomerName() + "\n")
                .append("Account No: " + getAccountNumber() + "\n")
                .append("Previous balance: " + monthlyBalance.getStartingBalance() + "\n")
                .append("Total deposit: " + totalDeposit + "\n")
                .append("Total withdrawal: " + totalWithdrawal + "\n")
                .append("Current balance: " + balance + "\n");
        return null;
    }
}
