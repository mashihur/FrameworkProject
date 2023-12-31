package framework.ui;

import java.time.LocalDate;

import framework.account.IAccount;


public class JDialog_CreatePersonalAccount extends javax.swing.JDialog {
	FinCoFrame parentFrame;

	public JDialog_CreatePersonalAccount(FinCoFrame parentframe) {
		super(parentframe);
		this.parentFrame = parentframe;

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parses your Java file into its visual environment.
		// {{ INIT_CONTROLS
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 303);
		setVisible(false);
		
		JLabel1.setText("Name");
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 46, 48, 24);
		getContentPane().add(JLabel1);

		JLabel2.setText("Street");
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 70, 48, 24);
		getContentPane().add(JLabel2);
		
		JLabel3.setText("City");
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 94, 48, 24);
		getContentPane().add(JLabel3);
		
		JLabel4.setText("State");
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 118, 48, 24);
		getContentPane().add(JLabel4);
		
		JLabel5.setText("Zip");
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 142, 48, 24);
		getContentPane().add(JLabel5);
		
		JLabel6.setText("Birthday");
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12, 166, 96, 24);
		getContentPane().add(JLabel6);
		
		JLabel7.setText("Email");
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 190, 48, 24);
		getContentPane().add(JLabel7);
		
		JTextField_NAME.setBounds(120, 46, 156, 20);
		getContentPane().add(JTextField_NAME);
		
		JTextField_CT.setBounds(120, 94, 156, 20);
		getContentPane().add(JTextField_CT);
		
		JTextField_ST.setBounds(120, 118, 156, 20);
		getContentPane().add(JTextField_ST);
		
		JTextField_STR.setBounds(120, 70, 156, 20);
		getContentPane().add(JTextField_STR);
		
		JTextField_ZIP.setBounds(120, 142, 156, 20);
		getContentPane().add(JTextField_ZIP);
		
		JTextField_BD.setBounds(120, 166, 156, 20);
		getContentPane().add(JTextField_BD);
		
		JTextField_EM.setBounds(120, 190, 156, 20);
		getContentPane().add(JTextField_EM);

		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		JButton_OK.setBounds(48, 226, 84, 24);
		getContentPane().add(JButton_OK);
		
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		JButton_Cancel.setBounds(156, 226, 84, 24);
		getContentPane().add(JButton_Cancel);
		
		JLabel8.setText("Acc Nr");
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12, 22, 48, 24);
		getContentPane().add(JLabel8);
		
		JTextField_ACNR.setBounds(120, 22, 156, 20);
		getContentPane().add(JTextField_ACNR);
		// }}

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		// }}
	}

	// {{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel8 = new javax.swing.JLabel();

	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();

	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
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

		this.parentFrame.getFinCo().createPersonalAccount(
				"",
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
		// make this frame invisible if Cancel button is clicked
		dispose();
	}
}