package creditCardCompany.ui;

import java.util.ArrayList;
import java.util.List;

import framework.FinCo;
import framework.account.IAccount;
import framework.customer.ICustomer;

import framework.ui.FinCoTableModel;

public class CreditTableModel extends FinCoTableModel {

    @Override
    public void update(FinCo finCo) {
        this.setRowCount(0);
        for (ICustomer customer : finCo.getCustomerList()) {
            for (IAccount account : customer.getAccountList()) {
                List<String> rowData = new ArrayList<>();
                rowData.add(account.getAccountNumber());
                rowData.add(customer.getCustomerName());
                rowData.add(customer.getCityName());
                rowData.add(account.getAccountType());
                rowData.add(Double.toString(account.getBalance()));
                this.addRow(rowData.toArray());
            }
        }
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
