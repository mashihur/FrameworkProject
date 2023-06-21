package framework.ui;

import java.awt.*;
import javax.swing.*;

import framework.FinCo;

/**
 * A basic JFC based application.
 **/
public class FinCoFrame extends javax.swing.JFrame {
	/****
	 * init variables in the object
	 ****/
	// String accountnr, clientName, street, city, zip, state, accountType,
	// clientType, amountDeposit;
	String amountDeposit;

	JTable JTable1;
	private JScrollPane JScrollPane1;
	protected FinCoFrame myframe;
	
	protected FinCo finco;
	
	public FinCo getFinco() {
		return finco;
	}

	protected FinCoTableModel model;

	public FinCoTableModel getModel() {
		return model;
	}

	public FinCoFrame() {
		myframe = this;

		setTitle("FinCo Framework");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(600, 350);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 600, 350);
		/*
		 * /Add five buttons on the pane
		 * /for Adding personal account, Adding company account
		 * /Deposit, Withdraw and Exit from the system
		 */
		finco = new FinCo();

		JScrollPane1 = new JScrollPane();

		model = new FinCoTableModel();
		
		model.setFinCo(finco);

		JTable1 = new JTable(model);

		JScrollPane1.setBounds(12, 92, 440, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		JPanel1.add(JScrollPane1);

		JButton_NewAccount.setText("Create new account");
		JButton_NewAccount.setBounds(24, 20, 160, 33);
		JPanel1.add(JButton_NewAccount);

		JButton_AddAC.setText("Add account");
		JButton_AddAC.setBounds(224, 20, 160, 33);
		JPanel1.add(JButton_AddAC);

		JButton_GenerateReport.setText("Generate Report");
		JButton_GenerateReport.setBounds(424, 20, 160, 33);
		JPanel1.add(JButton_GenerateReport);

		JButton_Addinterest.setText("Add interest");
		JButton_Addinterest.setBounds(468, 100, 100, 30);
		JPanel1.add(JButton_Addinterest);

		JButton_Deposit.setText("Deposit");
		JButton_Deposit.setBounds(468, 150, 100, 30);
		JPanel1.add(JButton_Deposit);

		JButton_Withdraw.setText("Withdraw");
		JButton_Withdraw.setBounds(468, 200, 100, 30);
		JPanel1.add(JButton_Withdraw);

		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 30);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		// $$ lineBorder1.move(24,312);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewAccount.addActionListener(lSymAction);
		JButton_AddAC.addActionListener(lSymAction);
		JButton_GenerateReport.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);

	}

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_AddAC = new javax.swing.JButton();
	javax.swing.JButton JButton_GenerateReport = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == FinCoFrame.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewAccount)
				JButtonNewAccount_actionPerformed(event);
			else if (object == JButton_AddAC)
				JButtonAddAC_actionPerformed(event);
			else if (object == JButton_GenerateReport)
				JButtonGenerateReport_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonNewAccount_actionPerformed(java.awt.event.ActionEvent event) {

		createNewAccountButton();
	}

	protected void createNewAccountButton() {
		JDialog_ChooseNewAccountType pac = new JDialog_ChooseNewAccountType(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

	void JButtonAddAC_actionPerformed(java.awt.event.ActionEvent event) {
		this.addCustomerAccountButton();
	}

	protected void addCustomerAccountButton() {
		JDialog_AddCustomerAccount pac = new JDialog_AddCustomerAccount(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

	void JButtonGenerateReport_actionPerformed(java.awt.event.ActionEvent event) {

		JDialog_GenerateReport pac = new JDialog_GenerateReport(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.setVisible(true);

			// compute new amount
			if (amountDeposit != null) {
				long deposit = Long.parseLong(amountDeposit);
				String samount = (String) model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount + deposit;
				model.setValueAt(String.valueOf(newamount), selection, 5);
				amountDeposit = null;
			}
		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.setVisible(true);

			// compute new amount
			if (amountDeposit != null) {
				long deposit = Long.parseLong(amountDeposit);
				String samount = (String) model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount - deposit;
				model.setValueAt(String.valueOf(newamount), selection, 5);
				if (newamount < 0) {
					JOptionPane.showMessageDialog(JButton_Withdraw,
							" Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !",
							"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
				}
				amountDeposit = null;
			}

		}

	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog_AddInterest ai = new JDialog_AddInterest(myframe);
		ai.setBounds(430, 15, 275, 140);
		ai.setVisible(true);
		;
	}
}
