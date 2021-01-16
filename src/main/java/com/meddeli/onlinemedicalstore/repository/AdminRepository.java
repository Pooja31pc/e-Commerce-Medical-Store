package com.meddeli.onlinemedicalstore.repository;

import com.meddeli.onlinemedicalstore.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

//     Admin fetchUserByEmailAndPassword(String emailid, String password);

}
