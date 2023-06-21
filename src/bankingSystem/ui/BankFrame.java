package bankingSystem.ui;

import bankingSystem.Bank;

import framework.FinCo;
import framework.ui.FinCoFrame;
import framework.ui.FinCoTableModel;

public class BankFrame extends FinCoFrame {	

	public BankFrame(FinCo finCo, FinCoTableModel model) {
		super();
		this.finco = finco;
		this.model = model;
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
