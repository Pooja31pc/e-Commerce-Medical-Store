package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.CartProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductItemRepository extends JpaRepository<CartProductItem, Long> {
}
