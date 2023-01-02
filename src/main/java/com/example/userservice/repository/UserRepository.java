package com.example.userservice.repository;

import com.example.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select u from UserEntity u where u.userId = ?1")
    Optional<UserEntity> findUserEntityByUserId(String userId);

    @Query("select u from UserEntity u where u.email = ?1")
    Optional<UserEntity> findUserEntityByEmail(String username);
}
