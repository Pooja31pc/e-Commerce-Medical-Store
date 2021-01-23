package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.CartFoodItem;
import com.meddeli.onlinemedicalstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartFoodItemRepository extends JpaRepository<CartFoodItem, Long> {
}
