package com.rross.marketplace.projector.repositories.impl;


import com.rross.marketplace.domain.model.Product;
import com.rross.marketplace.entities.ProductEntity;
import com.rross.marketplace.projector.repositories.dao.IProductDao;
import com.rross.marketplace.projector.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepository implements IProductRepository {
    private IProductDao productDao;

    public ProductRepository(@Autowired IProductDao productDao) {
        this.productDao = productDao;
    }


    public long upsertProduct(Product product, Optional<Long> brandId) {
        ProductEntity productEnt = ProductEntity.builder()
                .name(product.getName())
                .brandID(brandId.get())
                .build();


        // Need to find a good way to see if a product has a similar name to something in the system
        // This will do for now
        ProductEntity existingProduct = productDao.findFirstByName(product.getName());
        return existingProduct == null
            ? productDao.save(productEnt).getId()
            : existingProduct.getId();
    }
}
