package com.example.quroapp.Repositories;

import com.example.quroapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(nativeQuery = true,value="select * from User where id=:userId")
    Optional<User> findByUserId(UUID userId);
}
