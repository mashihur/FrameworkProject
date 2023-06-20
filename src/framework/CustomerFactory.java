package framework;

public class CustomerFactory implements  ICustomerFactory {
    @Override
    public IPerson createPerson() {
        return new Person();
    }

    @Override
    public ICompany createCompany() {
        return new Company();
    }
}
