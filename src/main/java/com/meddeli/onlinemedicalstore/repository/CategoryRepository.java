package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productcategory", path = "product-category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
