package com.demo.web.emarket.application.order;

import com.demo.web.emarket.domain.UniqueId;
import com.demo.web.emarket.domain.order.Quantity;
import com.demo.web.emarket.domain.product.Product;

public class OrderSingleProductCommand {
    private final UniqueId customerId;
    private final Product product;
    private final Quantity quantity;

    public OrderSingleProductCommand(UniqueId customerId, Product product, Quantity quantity) {
        this.customerId = customerId;
        this.product = product;
        this.quantity = quantity;
    }

    public UniqueId getCustomerId() {
        return customerId;
    }

    public Product getProduct() {
        return product;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
