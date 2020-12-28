package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
