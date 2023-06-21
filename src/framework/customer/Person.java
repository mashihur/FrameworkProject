package framework.customer;

import java.time.LocalDate;
import java.util.Date;

public class Person extends Customer implements IPerson {
    String birthday;

    public Person(String name, String email, String street, String city, String state, String zip, String birthday) {
        super(name, email, street, city, state, zip);
        this.birthday = birthday;
    }

    @Override
    public String getCustomerType() {
        return "P";
    }
}



