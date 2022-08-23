package com.example.EntityRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sub_categoryRequest {

    @NotBlank(message = "Sub_cate_code không được để trống, không nhập khoảng trắng")
    @Pattern(regexp = "SA[0-9]{4}+", message = "Code phải theo format: SA + 4 số")
    private String subcode;

    @NotBlank(message = "Sub_cate_name không được để trống, không nhập khoảng trắng")
    private String subname;

    @NotNull
    private Long cateid;

}
