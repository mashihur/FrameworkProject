package creditCardCompany.ui;

import java.util.ArrayList;
import java.util.List;

import framework.account.IAccount;
import framework.customer.ICustomer;

import framework.ui.FinCoTableModel;

public class CreditTableModel extends FinCoTableModel {

    @Override
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

    @Override
    protected void addAllColumns() {
        addColumn("AcctNr");
        addColumn("Name");
        addColumn("City");
        addColumn("G/S/C");
        addColumn("Amount");
    }
}
