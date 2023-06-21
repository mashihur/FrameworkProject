package bankingSystem.ui;

import java.time.LocalDate;

import framework.account.IAccount;

public class JDialog_AddCustomerBankAccount extends javax.swing.JDialog {
    BankFrame parentFrame;

    public JDialog_AddCustomerBankAccount(BankFrame parent) {
        super(parent);
        this.parentFrame = parent;

        setTitle("Add customer's account");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(298, 339);
        setVisible(false);

        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");
        JRadioButton_Chk.setBounds(36, 12, 84, 24);
        getContentPane().add(JRadioButton_Chk);

        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        JRadioButton_Sav.setBounds(36, 36, 84, 24);
        getContentPane().add(JRadioButton_Sav);

        group.add(JRadioButton_Chk);
        group.add(JRadioButton_Sav);

        JLabel1.setText("Name");
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12, 72, 48, 24);
        getContentPane().add(JLabel1);
        
        JTextField_NAME.setBounds(120, 72, 156, 20);
        getContentPane().add(JTextField_NAME);
        
        JLabel8.setText("Acc Nr");
        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12, 96, 48, 24);
        getContentPane().add(JLabel8);
        
        JTextField_ACNR.setBounds(120, 96, 156, 20);
        getContentPane().add(JTextField_ACNR);

        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        JButton_OK.setBounds(48, 276, 84, 24);
        getContentPane().add(JButton_OK);

        JButton_Calcel.setText("Cancel");
        JButton_Calcel.setActionCommand("Cancel");
        JButton_Calcel.setBounds(156, 276, 84, 24);
        getContentPane().add(JButton_Calcel);

        // {{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Calcel.addActionListener(lSymAction);
        // }}
    }

    // {{DECLARE_CONTROLS
    javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
    javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();
    
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel8 = new javax.swing.JLabel();

    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
    
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
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
		if (JRadioButton_Chk.isSelected()) {
			accountType = "Ch";
		} else {
			accountType = "S";
		}

        IAccount newAccount = this.parentFrame.getFinCo().addAccount(
                accountType,
                this.parentFrame.getFinCo().getCustomerByName(JTextField_NAME.getText()),
                JTextField_ACNR.getText(),
                0,
                LocalDate.now().plusMonths(12));

        // this.parentFrame.getModel().addNewRow(newAccount);
        this.parentFrame.getModel().update(this.parentFrame.getFinCo());
                
        dispose();

    }

    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();

    }
}
