package creditCardCompany.ui;

import creditCardCompany.CCCompany;
import framework.FinCo;
import framework.ui.FinCoFrame;;

public class CreditCardFrame extends FinCoFrame {
	
    @Override
	protected FinCo createFinCo() {
		return new CCCompany();
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
