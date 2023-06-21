package framework.customer;

public interface ICustomerFactory {
    ICustomer createCustomer(String type, String name, String email, String street, String city, String state, String zip, String birthday, int noOfEmployee);
}
