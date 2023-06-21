package framework.customer;

public interface ICustomerFactory {
    IPerson createPerson(String name, String email, String street, String city, String state, String zip, String birthday);
    ICompany createCompany(String name, String email, String street, String city, String state, String zip, int noOfEmployee);
}
