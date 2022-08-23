package com.example.Repository;

import com.example.Entity.Sub_category;
import com.example.EntityDto.Sub_categoryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Sub_categoryRepository extends JpaRepository<Sub_category, Long> {

    @Query("SELECT new com.example.EntityDto.Sub_categoryDto(sub.sub_id,sub.sub_cate_code,c.cate_name) FROM Sub_category sub join sub.category c order by sub.sub_id")
    List<Sub_categoryDto> getAllSub(Pageable pageable);

}
