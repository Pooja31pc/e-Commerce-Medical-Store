package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "productcategory", path = "product-category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Transactional
    @Modifying
    @Query("delete from Category pe where pe.id=:categoryId")
    void deleteByCategoryId(@Param("categoryId")long categoryid);
}
