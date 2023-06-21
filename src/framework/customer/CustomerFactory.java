package framework.customer;

import framework.Constants;

public class CustomerFactory implements  ICustomerFactory {
    @Override
    public ICustomer createCustomer(String type, String name, String email, String street, String city, String state, String zip, String birthday, int noOfEmployee) {
        if (type.equals(Constants.PERSONAL_ACCOUNT)) {
            return new Person(name, email, street, city, state, zip, birthday);
        } else {
            return new Company(name, email, street, city, state, zip, noOfEmployee);
        }
    }

}
