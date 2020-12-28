package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
