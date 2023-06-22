package banking.ui;

import java.awt.BorderLayout;

import framework.ui.FinCoFrame;

public class JDialog_ChooseNewBankAccountType extends javax.swing.JDialog {
    private FinCoFrame parentframe;

    public JDialog_ChooseNewBankAccountType(BankFrame bankFrame) {
        super(bankFrame);
        parentframe = bankFrame;

        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 200, 100);

        JButton_PerAC.setText("Create personal account");
        JButton_PerAC.setBounds(24, 20, 160, 33);
        JButton_PerAC.setActionCommand("jbutton");
        JPanel1.add(JButton_PerAC);

        JButton_CompAC.setText("Create company account");
        JButton_CompAC.setBounds(24, 60, 160, 33);
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);

        SymAction lSymAction = new SymAction();
        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);

    }

    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
    javax.swing.JButton JButton_CompAC = new javax.swing.JButton();

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_PerAC)
                JButtonPerAC_actionPerformed(event);
            else if (object == JButton_CompAC)
                JButtonCompAC_actionPerformed(event);

        }
    }

    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
        /*
         * JDialog_AddPAcc type object is for adding personal information
         * construct a JDialog_AddPAcc type object
         * set the boundaries and show it
         */

        JDialog_CreatePersonalAccount pac = new JDialog_CreatePersonalAccount(parentframe);
        pac.setBounds(450, 20, 300, 330);
        pac.setVisible(true);

        dispose();
    }

    void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
        /*
         * construct a JDialog_AddCompAcc type object
         * set the boundaries and
         * show it
         */

        JDialog_CreateCompanyAccount pac = new JDialog_CreateCompanyAccount(parentframe);
        pac.setBounds(450, 20, 300, 330);
        pac.setVisible(true);

        dispose();
    }
}
