package framework;

public interface IAccount {
     void addInterest(double interest);
     String generateMonthlyRecord();
     void addEntry(IEntry entry);
     void deposit(double amount);
     void withdrawOrCharge(double amount);
     String getAccountNumber();
}
