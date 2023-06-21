package framework.customer;

public class CustomerFactory implements  ICustomerFactory {
    @Override
    public IPerson createPerson(String name, String email, String street, String city, String state, String zip, String birthday) {
        return new Person(name, email, street, city, state, zip, birthday);
    }

    @Override
    public ICompany createCompany(String name, String email, String street, String city, String state, String zip, int noOfEmployee) {
        return new Company(name, email, street, city, state, zip, noOfEmployee);
    }
}
