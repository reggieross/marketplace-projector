package com.rross.marketplace.projector.repositories;

import com.rross.marketplace.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IProductRepository {
    long upsertProduct(Product product, Optional<Long> brandId);
}
