package com.demo.web.emarket.domain;

import com.demo.web.emarket.domain.ddd.BaseValueObject;
import com.demo.web.emarket.domain.ddd.DDD;

import javax.validation.constraints.NotBlank;
import java.util.List;

import static java.util.Arrays.asList;

@DDD.ValueObject
public class Address extends BaseValueObject<Address> {
    @NotBlank
    private final String streetName;

    private final Integer streetNumber;

    public Address(String streetName, Integer streetNumber) {
        super(Address.class);
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        validate(this);
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    /*Used by JPA dont use in production code*/
    public Address() {
        super(Address.class);
        streetName = null;
        streetNumber = 0;
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(streetName, streetNumber);
    }
}
