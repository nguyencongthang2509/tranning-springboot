package com.example.Service;

import com.example.Entity.*;
import com.example.EntityDto.ProductDto;
import com.example.EntityDto.Sub_categoryDto;
import com.example.EntityRequest.ProductRequest;
import com.example.EntityRequest.ProductRequestUpdate;
import com.example.EntityRequest.Sub_categoryRequest;
import com.example.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTest implements ServiceInterface {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Sub_categoryRepository sub_categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private Product_brandRepository product_brandRepository;

    //câu 1
    @Override
    public List<Sub_categoryDto> getAllSub(Pageable pageable) {
        List<Sub_categoryDto> listSubDto = sub_categoryRepository.getAllSub(pageable);
        return listSubDto;
    }

    //câu 2
    @Override
    public String addSub_category(Sub_categoryRequest sub_categoryRequest) {

        Optional<Category> category = categoryRepository.findById(sub_categoryRequest.getCateid());

        if (!category.isPresent()) {
            return "Category này không tồn tại";
        }

        String name = sub_categoryRequest.getSubname();
        try {
            Double.parseDouble(name);
            return "Name phải là chữ";
        } catch (Exception e) {
        }

        Sub_category sub_category = new Sub_category();
        sub_category.setSub_cate_code(sub_categoryRequest.getSubcode());
        sub_category.setSub_cate_name(sub_categoryRequest.getSubname());
        sub_category.setCategory(category.get());
        sub_categoryRepository.save(sub_category);
        return "Add thành công 1 SubCate";
    }

    // câu 3
    @Override
    public String updateSub(Long id, Sub_categoryRequest sub_categoryRequest) {
        Optional<Sub_category> sub_categoryCheck = sub_categoryRepository.findById(id);
        Optional<Category> category = categoryRepository.findById(sub_categoryRequest.getCateid());

        if (!sub_categoryCheck.isPresent()) {
            return "Sub_category này không tồn tại";
        }
        if (!category.isPresent()) {
            return "Category này không tồn tại";
        }

        String name = sub_categoryRequest.getSubname();
        try {
            Double.parseDouble(name);
            return "Name phải là chuỗi";
        } catch (Exception e) {
        }
        //Cách 1
//        Sub_category sub_categoryUpdate = new Sub_category();
//        sub_categoryUpdate.setSub_id(id);
//        sub_categoryUpdate.setSub_cate_code(sub_categoryRequest.getSubcode());
//        sub_categoryUpdate.setSub_cate_name(sub_categoryRequest.getSubname());
//        sub_categoryUpdate.setCategory(category.get());
        //Cách 2
        sub_categoryCheck.get().setSub_cate_code(sub_categoryRequest.getSubcode());
        sub_categoryCheck.get().setSub_cate_name(sub_categoryRequest.getSubname());
        sub_categoryCheck.get().setCategory(category.get());
        sub_categoryRepository.save(sub_categoryCheck.get());
        return "Update thành công";
    }

    //câu 4
    @Override
    public List<ProductDto> getAllProduct(Pageable pageable) {
        List<ProductDto> listProDto = productRepository.getProduct(pageable);
        return listProDto;
    }

    @Override
    public Optional<Status> checkStatusName(String text) {
        for (Status xx : statusRepository.findAll()) {
            if (text.equals(xx.getStatus_name())) {
                return Optional.of(xx);
            }
        }
        return null;
    }

    //câu 5
    @Override
    public String addProduct(ProductRequest productRequest) {
        Optional<Brand> BrandCheck = brandRepository.findById(productRequest.getBrandId());

        Optional<Sub_category> Sub_categoryCheck = sub_categoryRepository.findById(productRequest.getSubCateId());

        Optional<Status> statusCheck = checkStatusName(productRequest.getStatusName());

        if (!BrandCheck.isPresent()) {
            return "Brand này không tồn tại";
        }

        if (!Sub_categoryCheck.isPresent()) {
            return "Sub_category này không tồn tại";
        }

        if (statusCheck == null) {
            return "Status này không tồn tại";
        }

        if (productRequest.getSellPrice() <= productRequest.getOriginPrice()) {
            return "SellPrice phải lớn hơn originPrice";
        }

        Product addProduct = new Product();
        addProduct.setSub_category(Sub_categoryCheck.get());
        addProduct.setProduct_name(productRequest.getProductName());
        addProduct.setColor(productRequest.getColor());
        addProduct.setQuantity(productRequest.getQuantity());
        addProduct.setSell_price(productRequest.getSellPrice());
        addProduct.setOrigin_price(productRequest.getOriginPrice());
        addProduct.setDescription(productRequest.getDescription());
        addProduct.setStatus(statusCheck.get());
        productRepository.save(addProduct);

        Product_brand product_brand = new Product_brand();
        product_brand.setBrand_id(BrandCheck.get().getId());
        product_brand.setProduct_id(addProduct.getId());
        product_brand.setBrands(BrandCheck.get());
        product_brand.setProducts(addProduct);
        System.out.println(product_brand);
        product_brandRepository.save(product_brand);
        return "Add thành công 1 product";
    }

    //câu 6
    @Override
    public String deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            return "Product này không tồn tại";
        }
        product_brandRepository.deleteProduct_brand(id);
        productRepository.deleteById(id);
        return "Deleted Successful";
    }

    @Override
    public Optional<Brand> checkBrandName(String text) {
        for (Brand xx : brandRepository.findAll()) {
            if (text.equals(xx.getBrand_name())) {
                return Optional.of(xx);
            }
        }
        return null;
    }

    @Override
    public Optional<Sub_category> checkSubCateName(String text) {
        for (Sub_category xx : sub_categoryRepository.findAll()) {
            if (text.equals(xx.getSub_cate_name())) {
                return Optional.of(xx);
            }
        }
        return null;
    }

    //câu 7
    @Override
    public String updateProduct(Long id, ProductRequestUpdate productRequestUpdate) {
        Optional<Product> productCheck = productRepository.findById(id);

        Optional<Brand> BrandCheck = checkBrandName(productRequestUpdate.getBrandName());

        Optional<Sub_category> Sub_categoryCheck = checkSubCateName(productRequestUpdate.getSubCateName());

        Optional<Status> StatusCheck = checkStatusName(productRequestUpdate.getStatusName());

        if (!productCheck.isPresent()) {
            return "Product này không tồn tại";
        }

        if (BrandCheck == null) {
            return "Brand này không tồn tại";
        }

        if (Sub_categoryCheck == null) {
            return "Sub_category này không tồn tại";
        }

        if (StatusCheck == null) {
            return "Status này không tồn tại";
        }

        if (productRequestUpdate.getSellPrice() <= productRequestUpdate.getOriginPrice()) {
            return "SellPrice phải lớn hơn originPrice";
        }
        //Cách 1
//        Product productSave = new Product(id, Sub_categoryCheck.get(), productRequestUpdate.getProductName(), productRequestUpdate.getColor()
//                , productRequestUpdate.getQuantity(), productRequestUpdate.getSellPrice(), productRequestUpdate.getOriginPrice(),
//                productRequestUpdate.getDescription(), StatusCheck.get());
//        productRepository.save(productSave);
        //Cách 2
        productCheck.get().setSub_category(Sub_categoryCheck.get());
        productCheck.get().setProduct_name(productRequestUpdate.getProductName());
        productCheck.get().setColor(productRequestUpdate.getColor());
        productCheck.get().setQuantity(productRequestUpdate.getQuantity());
        productCheck.get().setSell_price(productRequestUpdate.getSellPrice());
        productCheck.get().setOrigin_price(productRequestUpdate.getOriginPrice());
        productCheck.get().setDescription(productRequestUpdate.getDescription());
        productCheck.get().setStatus(StatusCheck.get());

        productRepository.save(productCheck.get());

        product_brandRepository.updateProduct_brand(BrandCheck.get(), BrandCheck.get().getId(), id);
        return "Update thành công";
    }

}
