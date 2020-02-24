package com.rross.marketplace.projector.repositories.dao;

import com.rross.marketplace.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("productDao")
@Transactional
public interface IProductDao extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM product p WHERE p.name = :name")
    ProductEntity findFirstByName(@Param("name") String name);
}