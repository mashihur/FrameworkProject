package bankingSystem.ui;

import bankingSystem.Bank;
import framework.FinCo;
import framework.ui.FinCoFrame;

public class BankFrame extends FinCoFrame {	
	
    @Override
	protected FinCo createFinCo() {
		return new Bank();
	}
	
	@Override
	protected void createNewAccountButton() {
		JDialog_ChooseNewBankAccountType pac = new JDialog_ChooseNewBankAccountType(this);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

	@Override
	protected void addCustomerAccountButton() {
		JDialog_AddCustomerBankAccount pac = new JDialog_AddCustomerBankAccount(this);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

}
