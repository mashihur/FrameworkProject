package framework.ui;

import javax.swing.JOptionPane;

public class JDialog_AddInterest extends javax.swing.JDialog {
    FinCoFrame parentFrame;

    public JDialog_AddInterest(FinCoFrame parent) {
        super(parent);
        this.parentFrame = parent;

        // This code is automatically generated by Visual Cafe when you add
        // components to the visual environment. It instantiates and initializes
        // the components. To modify the code, only use code syntax that matches
        // what Visual Cafe can generate, or Visual Cafe may be unable to back
        // parses your Java file into its visual envirenment.
        // {{ INIT_CONTROLS
        setTitle("Deposit");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(266, 126);
        setVisible(false);

        JLabel1.setText("Amount");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12, 48, 48, 24);

        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(36, 84, 84, 24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156, 84, 84, 24);
        getContentPane().add(JTextField_Interest);
        JTextField_Interest.setBounds(84, 48, 144, 24);
        // }}

        // {{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Cancel.addActionListener(lSymAction);
        // }}
    }

    // {{DECLARE_CONTROLS
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
    javax.swing.JTextField JTextField_Interest = new javax.swing.JTextField();
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
        this.parentFrame.getFinCo().addInterest(Double.parseDouble(JTextField_Interest.getText()));
        JOptionPane.showMessageDialog(JButton_OK, "Add interest to all accounts",
                "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);

        this.parentFrame.getModel().update(this.parentFrame.getFinCo());

        dispose();
    }

    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }
}
