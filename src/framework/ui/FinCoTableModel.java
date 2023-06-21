package framework.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import framework.FinCo;
import framework.customer.ICustomer;

public class FinCoTableModel extends DefaultTableModel {

    private FinCo finCo;

    public FinCoTableModel() {
        super();
        this.addAllColumns();
    }

    public void setFinCo(FinCo finCo) {
        this.finCo = finCo;
    }

    public void update() {
        // for (ICustomer customer : this.parentFrame.getFinco().getCustomerList()) {
        //     customer.name;
        // }
    }

    public void addRowData(String accNr, String name, String city, String cusType, String accType, String amount) {
        List<String> rowData = new ArrayList<>();
        rowData.add(accNr);
        rowData.add(name);
        rowData.add(city);
        rowData.add(cusType);
        rowData.add(accType);
        rowData.add(amount);
        this.addRow(rowData.toArray());
    }


    private void addAllColumns() {
        addColumn("AcctNr");
        addColumn("Name");
        addColumn("City");
        addColumn("P/C");
        addColumn("Ch/S");
        addColumn("Amount");
    }

}
