package com.example.Repository;

import com.example.Entity.Product;
import com.example.EntityDto.ProductDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(" select new com.example.EntityDto.ProductDto(d.id, sub.sub_cate_name, d.product_name,d.color,d.quantity, d.sell_price, d.origin_price , sta.status_name , pb.brands.brand_name)" +
            " from Product d inner join Product_brand pb on d.id = pb.products.id join d.sub_category sub join d.status sta order by d.id")
    List<ProductDto> getProduct(Pageable pageable);
}
