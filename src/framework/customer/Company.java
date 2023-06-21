package framework.customer;

public class Company extends Customer implements ICompany {
    int noOfEmployee;

    public Company(String name, String email, String street, String city, String state, String zip, int noOfEmployee) {
        super(name, email, street, city, state, zip);
        this.noOfEmployee = noOfEmployee;
    }

    @Override
    public String getCustomerType() {
        return "C";
    }
}
