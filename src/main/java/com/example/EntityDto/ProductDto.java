package com.example.EntityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String subCateName;
    private String productName;
    private String color;
    private int quantity;
    private double sellPrice;
    private double originPrice;
    private String statusName;
    private String brandName;
}
