package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productbrand", path = "product-brand")
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
