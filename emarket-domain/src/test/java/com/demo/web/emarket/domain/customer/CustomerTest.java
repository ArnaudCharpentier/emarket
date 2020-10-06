package com.demo.web.emarket.domain.customer;

import com.demo.web.emarket.domain.Address;
import com.demo.web.emarket.domain.UniqueId;
import com.demo.web.emarket.domain.ddd.DomainConstraintViolationException;
import org.junit.Test;

import static java.time.LocalDateTime.now;
import static java.util.Collections.emptySet;

public class CustomerTest {
    private CustomerName customerName = new CustomerName(new NamePart("John"), new NamePart("Doe"));

    @Test(expected = DomainConstraintViolationException.class)
    public void when_null_address_then_constraint_violation() {
        new Customer(new UniqueId(), customerName, null, new CreditCard("1234 6457 8888 9999"),
                new PhoneNumber("+07222222"), new HistoricData(now(), now()), emptySet());
    }

    @Test
    public void when_null_credit_card_then_accept_customer_instance() {
        new Customer(
                new UniqueId(), customerName,
                new Address("New York street", 43), null,
                new PhoneNumber("+07222222"), new HistoricData(now(), now()), emptySet()
        );
    }

    @Test(expected = NullPointerException.class)
    public void when_null_id_then_constraint_violation() {
        new Customer(
                null, customerName,
                new Address("New York street", 43), null,
                new PhoneNumber("+07222222"), new HistoricData(now(), now()), emptySet()
        );
    }
}
