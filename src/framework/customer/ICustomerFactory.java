package framework.customer;

public interface ICustomerFactory {
    IPerson createPerson();
    ICompany createCompany();
}
