package com.example.Service;

import com.example.Entity.Brand;
import com.example.Entity.Status;
import com.example.Entity.Sub_category;
import com.example.EntityDto.ProductDto;
import com.example.EntityDto.Sub_categoryDto;
import com.example.EntityRequest.ProductRequest;
import com.example.EntityRequest.ProductRequestUpdate;
import com.example.EntityRequest.Sub_categoryRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {

    Object addSub_category(Sub_categoryRequest sub_categoryRequest);

    List<Sub_categoryDto> getAllSub(Pageable pageable);

    List<ProductDto> getAllProduct(Pageable pageable);

    Object updateSub(Long id, Sub_categoryRequest sub_categoryRequest);

    Object addProduct(ProductRequest productRequest);

    String deleteProduct(Long id);

    Optional<Status> checkStatusName(String text);

    Optional<Brand> checkBrandName(String text);

    Optional<Sub_category> checkSubCateName(String text);

    String updateProduct(Long id, ProductRequestUpdate productRequestUpdate);
}
