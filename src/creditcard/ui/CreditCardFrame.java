package creditcard.ui;

import creditcard.CCCompany;
import framework.ui.FinCoFrame;

public class CreditCardFrame extends FinCoFrame {
	
	public CreditCardFrame() {
		super();
		this.setFinCo(new CCCompany());
		this.setModel(new CreditTableModel());
		this.setWithdrawButtonText("Charge");
	}
	
	@Override
	protected void createNewAccountButton() {
		JDialog_CreateCreditCardAccount pac = new JDialog_CreateCreditCardAccount(this);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

	@Override
	protected void addCustomerAccountButton() {
		JDialog_AddCustomerCreditAccount pac = new JDialog_AddCustomerCreditAccount(this);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}
}
