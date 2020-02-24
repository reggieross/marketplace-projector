package com.rross.marketplace.projector.impl;

import com.rross.marketplace.domain.model.Product;
import com.rross.marketplace.projector.IProjector;
import com.rross.marketplace.projector.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Projector implements IProjector {
    private IProductRepository productRepository;

    public Projector(
        @Autowired IProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    public long createProduct(Product product) {
        return productRepository.upsertProduct(product, null);
    }
}
