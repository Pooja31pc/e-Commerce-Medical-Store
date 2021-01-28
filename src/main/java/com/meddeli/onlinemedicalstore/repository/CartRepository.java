package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.Cart;
import com.meddeli.onlinemedicalstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select d from Cart d where d.ordered=false AND d.user=:user")
    List<Cart> getUnorderedCartList(@Param("user") User user);

}
