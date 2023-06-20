package framework;

public interface ICustomerFactory {
    IPerson createPerson();
    ICompany createCompany();
}
