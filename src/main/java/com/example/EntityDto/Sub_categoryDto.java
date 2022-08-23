package com.example.EntityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sub_categoryDto {
    private Long subId;
    private String subCode;
    private String cateName;

}
