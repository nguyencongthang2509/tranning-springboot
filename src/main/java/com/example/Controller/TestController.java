package com.example.Controller;

import com.example.Entity.*;
import com.example.EntityDto.ProductDto;
import com.example.EntityDto.Sub_categoryDto;
import com.example.EntityRequest.ProductRequest;
import com.example.EntityRequest.ProductRequestUpdate;
import com.example.EntityRequest.Sub_categoryRequest;
import com.example.Service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ServiceTest serviceTest;

    //câu 1
    @GetMapping("/subcates/{page}")
    public List<Sub_categoryDto> getAllSubDto(@PathVariable int page) {
        Pageable pageRequest = PageRequest.of(page - 1, 5);
        List<Sub_categoryDto> list = serviceTest.getAllSub(pageRequest);
        return list;
    }

    //câu 2
    @PostMapping("/addsub_category")
    public ResponseEntity<?> createSub_category(@Valid @RequestBody Sub_categoryRequest sub_categoryRequest) {
        String response = serviceTest.addSub_category(sub_categoryRequest);
        return new ResponseEntity<Object>(response, HttpStatus.CREATED);
    }

    //câu 3
    @PutMapping("/updatesub_category/{id}")
    public String updateSub_category(@Valid @RequestBody Sub_categoryRequest sub_categoryRequest, @PathVariable Long id) {
        String response = serviceTest.updateSub(id, sub_categoryRequest);
        return response;
    }

    //câu 4
    @GetMapping("/products/{page}")
    public List<ProductDto> getAllProductDto(@PathVariable int page) {
        Pageable pageRequest = PageRequest.of(page - 1, 5);
        List<ProductDto> list = serviceTest.getAllProduct(pageRequest);
        return list;
    }

    //câu 5
    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductRequest productRequest) {
        String response = serviceTest.addProduct(productRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //câu 6
    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return serviceTest.deleteProduct(id);
    }

    //câu 7
    @PutMapping("/updateproduct/{id}")
    public String updateProduct(@Valid @RequestBody ProductRequestUpdate productRequestUpdate, @PathVariable Long id) {
        String response = serviceTest.updateProduct(id, productRequestUpdate);
        return response;
    }
}
