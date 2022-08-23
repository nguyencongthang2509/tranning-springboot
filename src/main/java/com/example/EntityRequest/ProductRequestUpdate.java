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
public class ProductRequestUpdate {

    @NotBlank(message = "Không được để trống")
    private String subCateName;

    @NotBlank(message = "Không được để trống")
    private String productName;

    @NotBlank(message = "Không được để trống")
    private String color;

    @NotNull
    @Min(value = 1,message = "Quantity phải là số nguyên dương")
    private int quantity;

    @NotNull
    private double sellPrice;

    @NotNull
    private double originPrice;

    @NotBlank(message = "Không được để trống")
    private String description;

    @NotBlank(message = "Không được để trống")
    private String statusName;

    @NotBlank(message = "Không được để trống")
    private String brandName;
}
