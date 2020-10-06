package com.demo.web.emarket.domain.product;

import com.demo.web.emarket.domain.ddd.DomainConstraintViolationException;
import org.junit.Test;

import java.math.BigDecimal;

public class PriceTest {

    @Test(expected = DomainConstraintViolationException.class)
    public void value_should_not_be_lower_than_0() {
        new Price(new BigDecimal("-0.1"));
    }

    @Test(expected = DomainConstraintViolationException.class)
    public void value_should_not_be_higher_than_1000000() {
        new Price(new BigDecimal("1000000.01"));
    }

    @Test(expected = NumberFormatException.class)
    public void value_should_not_empty_string() {
        new Price("");
    }
}
