package com.example.Entity;

import com.example.ProductBrandKey.ProductBrandKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product_brand")
@IdClass(ProductBrandKey.class)
public class Product_brand {

    @Id
    private Long product_id;

    @Id
    private Long brand_id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product products;

    @ManyToOne
    @MapsId("brand_id")
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brands;
}

