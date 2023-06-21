package bankingSystem;

import bankingSystem.ui.BankFrame;
import framework.ui.FinCoFrame;

public class BankMain {
    public static void main(String[] args) {
        FinCoFrame bankApp = new BankFrame();
        bankApp.setTitle("Bank Application");
        bankApp.setVisible(true);
    }

}
