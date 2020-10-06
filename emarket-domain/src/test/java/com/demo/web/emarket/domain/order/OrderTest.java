package com.demo.web.emarket.domain.order;

import com.demo.web.emarket.domain.UniqueId;
import com.demo.web.emarket.domain.ddd.DomainConstraintViolationException;
import org.junit.Test;

import java.util.Collections;

public class OrderTest {

    @Test(expected = DomainConstraintViolationException.class)
    public void order_with_empty_order_lines_is_rejected() {
        new Order(Collections.emptyList(), OrderStatus.INITIATED, new UniqueId());
    }
}
