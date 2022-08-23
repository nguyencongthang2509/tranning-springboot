package com.example.Repository;

import com.example.Entity.Brand;
import com.example.Entity.Product_brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface Product_brandRepository extends JpaRepository<Product_brand, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from product_brand where product_id = ?1",nativeQuery = true)
    void deleteProduct_brand(Long id);

    @Modifying
    @Transactional
    @Query("update Product_brand sub set sub.brands = :brands , sub.brand_id = :brand_id where sub.product_id = :product_id")
    void updateProduct_brand(@Param("brands") Brand brands,@Param("brand_id") Long brand_id,@Param("product_id") Long product_id);
}
