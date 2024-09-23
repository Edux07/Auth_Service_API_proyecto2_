package com.example.authservice_proyecto2.Repository;


import com.example.authservice_proyecto2.common.entities.userModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<userModel, Long> {
    Optional<userModel> findByEmail(String email);

}
