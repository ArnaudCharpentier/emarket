package com.demo.web.emarket.domain.customer;

import com.demo.web.emarket.domain.ddd.BaseValueObject;
import com.demo.web.emarket.domain.ddd.DDD;

import java.util.List;

import static java.util.Arrays.asList;

@DDD.ValueObject
public class CustomerName extends BaseValueObject<CustomerName> {
    private final NamePart firstName;
    private final NamePart lastName;

    public CustomerName(NamePart firstName, NamePart lastName) {
        super(CustomerName.class);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private CustomerName() {
        super(CustomerName.class);
        this.firstName = null;
        this.lastName = null;
    }

    public NamePart getFirstName() {
        return firstName;
    }

    public NamePart getLastName() {
        return lastName;
    }

    public String fullName() {
        return firstName.getValue() + " " + lastName.getValue();
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(firstName, lastName);
    }
}
