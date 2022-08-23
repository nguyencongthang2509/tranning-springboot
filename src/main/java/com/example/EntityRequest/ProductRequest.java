package com.example.EntityRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotNull
    private Long subCateId;

    @NotBlank(message = "Không được để trống,không nhập khoảng trắng")
    private String productName;

    @NotBlank(message = "Không được để trống,không nhập khoảng trắng")
    private String color;

    @Min(value = 1, message = "Quantity phải là số nguyên dương")
    @NotNull
    private int quantity;

    @NotNull
    private double sellPrice;

    @NotNull
    private double originPrice;

    @NotBlank(message = "Không được để trống,không nhập khoảng trắng")
    private String description;

    @NotBlank(message = "Không được để trống,không nhập khoảng trắng")
    private String statusName;

    @NotNull
    private Long brandId;
}
