package framework.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import framework.FinCo;
import framework.account.IAccount;
import framework.customer.ICustomer;

public class FinCoTableModel extends DefaultTableModel {

    public FinCoTableModel() {
        super();
        this.addAllColumns();
    }

    public void update(FinCo finCo) {
        this.setRowCount(0);
        for (ICustomer customer : finCo.getCustomerList()) {
            for (IAccount account : customer.getAccountList()) {
                List<String> rowData = new ArrayList<>();
                rowData.add(account.getAccountNumber());
                rowData.add(customer.getCustomerName());
                rowData.add(customer.getCityName());
                rowData.add(customer.getCustomerType());
                rowData.add(Double.toString(account.getBalance()));
                this.addRow(rowData.toArray());
            }
        }
    }

    protected void addAllColumns() {
        addColumn("AcctNr");
        addColumn("Name");
        addColumn("City");
        addColumn("P/C");
        addColumn("Amount");
    }

}
