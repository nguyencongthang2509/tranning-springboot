package com.example.ProductBrandKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBrandKey implements Serializable {
    private Long product_id;
    private Long brand_id;
}
