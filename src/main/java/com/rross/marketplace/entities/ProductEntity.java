package com.rross.marketplace.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @NotNull
    @Column(name = "name", columnDefinition="TEXT")
    private String name;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @Column(name = "brand_id")
    private Long brandID;

//    @ManyToMany
//    @JoinTable(name = "PRODUCT_CATEGORY",
//        joinColumns = {
//                @JoinColumn(name = "PRODUCT_ID",  nullable = false, updatable = false)
//        },
//        inverseJoinColumns = {
//            @JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false)
//        }
//    )
//    List<Category> categoryList;
}
