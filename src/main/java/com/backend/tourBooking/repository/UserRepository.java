package com.backend.tourBooking.repository;

import com.backend.tourBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByCorreoElectronico(String correoElectronico);
    
    Optional<User> findByCorreoElectronico(String correoElectronico);
}
