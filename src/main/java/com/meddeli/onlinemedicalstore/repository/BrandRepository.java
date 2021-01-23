package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "productbrand", path = "product-brand")
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Transactional
    @Modifying
    @Query("delete from Brand pe where pe.id=:brandId")
    void deleteByBrandId(@Param("brandId")long brandid);
}
