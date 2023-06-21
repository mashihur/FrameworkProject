package creditCardCompany.ui;

import framework.FinCo;
import framework.ui.FinCoFrame;
import framework.ui.FinCoTableModel;;

public class CreditCardFrame extends FinCoFrame {
	
	public CreditCardFrame(FinCo finCo, FinCoTableModel model) {
		super();
		this.finco = finco;
		this.model = model;
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
