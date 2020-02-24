package com.rross.marketplace.projector;

import com.rross.marketplace.domain.model.Product;

public interface IProjector {
    long createProduct(Product product);
}
