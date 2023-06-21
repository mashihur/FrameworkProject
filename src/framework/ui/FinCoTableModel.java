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

    public void addNewRow(IAccount newAccount) {
        List<String> rowData = new ArrayList<>();
        ICustomer customer = newAccount.getCustomer();
        rowData.add(newAccount.getAccountNumber());
        rowData.add(customer.getCustomerName());
        rowData.add(customer.getCityName());
        rowData.add("");
        rowData.add("0");
        this.addRow(rowData.toArray());
    }

    protected void addAllColumns() {
        addColumn("AcctNr");
        addColumn("Name");
        addColumn("City");
        addColumn("P/C");
        addColumn("Amount");
    }

}
