package framework.ui;

public class JDialog_Deposit extends javax.swing.JDialog {

	private FinCoFrame parentframe;
	private String accnr;

	public JDialog_Deposit(FinCoFrame parent, String aaccnr) {
		super(parent);
		parentframe = parent;
		accnr = aaccnr;

		setTitle("Deposit");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(266, 126);
		setVisible(false);

		JLabel1.setText("Acc Nr");
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		getContentPane().add(JLabel1);

		JLabel2.setText("Amount");
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 48, 48, 24);
		getContentPane().add(JLabel2);

		JTextField_NAME.setEditable(false);
		JTextField_NAME.setBounds(84, 12, 144, 24);
		getContentPane().add(JTextField_NAME);

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		JButton_OK.setBounds(36, 84, 84, 24);
		getContentPane().add(JButton_OK);

		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		JButton_Cancel.setBounds(156, 84, 84, 24);
		getContentPane().add(JButton_Cancel);

		JTextField_Deposit.setBounds(84, 48, 144, 24);
		getContentPane().add(JTextField_Deposit);
		// }}
		JTextField_NAME.setText(accnr);

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		// }}
	}

	// {{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();
	// }}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		parentframe.getFinco().deposit(Double.parseDouble(JTextField_Deposit.getText()),
				parentframe.getFinco().getAccountByAccountNumber(accnr));
		parentframe.amountDeposit = JTextField_Deposit.getText();
		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}

}