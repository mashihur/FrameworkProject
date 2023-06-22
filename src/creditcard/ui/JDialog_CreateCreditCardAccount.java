package creditcard.ui;

import java.time.LocalDate;

import creditcard.CreditConstants;
import framework.ui.FinCoFrame;

public class JDialog_CreateCreditCardAccount extends javax.swing.JDialog {
	FinCoFrame parentFrame;

	public JDialog_CreateCreditCardAccount(CreditCardFrame parent) {
		super(parent);
		parentFrame = parent;

		setTitle("Add credit card account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(300, 400);
		setVisible(false);

		JRadioButton_Gold.setText("Gold");
		JRadioButton_Gold.setActionCommand("Gold");
		JRadioButton_Gold.setBounds(36, 12, 84, 24);
		getContentPane().add(JRadioButton_Gold);

		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Silver");
		JRadioButton_Silver.setBounds(36, 36, 84, 24);
		getContentPane().add(JRadioButton_Silver);

		JRadioButton_Copper.setText("Copper");
		JRadioButton_Copper.setActionCommand("Copper");
		JRadioButton_Copper.setBounds(36, 60, 84, 24);
		getContentPane().add(JRadioButton_Copper);

		group.add(JRadioButton_Gold);
		group.add(JRadioButton_Silver);
		group.add(JRadioButton_Copper);

		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12, 80, 48, 24);

		JLabel1.setText("Name");
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 104, 48, 24);
		getContentPane().add(JLabel1);

		JLabel2.setText("Street");
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 128, 48, 24);
		getContentPane().add(JLabel2);

		JLabel3.setText("City");
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 152, 48, 24);
		getContentPane().add(JLabel3);

		JLabel4.setText("State");
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 176, 48, 24);
		getContentPane().add(JLabel4);

		JLabel5.setText("Zip");
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 200, 48, 24);
		getContentPane().add(JLabel5);

		JLabel6.setText("Birthday");
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 224, 96, 24);
		getContentPane().add(JLabel6);

		JLabel7.setText("Email");
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 248, 48, 24);
		getContentPane().add(JLabel7);

		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(120, 80, 156, 20);

		JTextField_NAME.setBounds(120, 104, 156, 20);
		getContentPane().add(JTextField_NAME);

		JTextField_STR.setBounds(120, 128, 156, 20);
		getContentPane().add(JTextField_STR);

		JTextField_CT.setBounds(120, 152, 156, 20);
		getContentPane().add(JTextField_CT);

		JTextField_ST.setBounds(120, 176, 156, 20);
		getContentPane().add(JTextField_ST);

		JTextField_ZIP.setBounds(120, 200, 156, 20);
		getContentPane().add(JTextField_ZIP);

		JTextField_BD.setBounds(120, 224, 156, 20);
		getContentPane().add(JTextField_BD);

		JTextField_EM.setBounds(120, 248, 156, 20);
		getContentPane().add(JTextField_EM);

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		JButton_OK.setBounds(48, 276, 84, 24);
		getContentPane().add(JButton_OK);

		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		JButton_Calcel.setBounds(156, 276, 84, 24);
		getContentPane().add(JButton_Calcel);

		// }}

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Calcel.addActionListener(lSymAction);
		// }}
	}

	// {{DECLARE_CONTROLS
	javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Copper = new javax.swing.JRadioButton();
	javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();

	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
	javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	// }}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Calcel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        String accountType;
        if (JRadioButton_Gold.isSelected()) {
            accountType = CreditConstants.GOLD_ACCOUNT;
        } else if (JRadioButton_Silver.isSelected()) {
            accountType = CreditConstants.SILVER_ACCOUNT;
        } else {
            accountType = CreditConstants.COPPER_ACCOUNT;
        }

		this.parentFrame.getFinCo().createPersonalAccount(
				accountType,
				JTextField_ACNR.getText(),
				0,
				LocalDate.now().plusMonths(12),
				JTextField_NAME.getText(),
				JTextField_EM.getText(),
				JTextField_STR.getText(),
				JTextField_CT.getText(),
				JTextField_ST.getText(),
				JTextField_ZIP.getText(),
				JTextField_BD.getText());

        this.parentFrame.getModel().update(this.parentFrame.getFinCo());

		dispose();

	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();

	}
}