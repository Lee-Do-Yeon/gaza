package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDto, String> {
    Optional<UserDto> findByUserId(String userId);
}
