package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT *  FROM user as u WHERE id=:id AND STATE!='US5'", nativeQuery = true)
    Optional<User> login(String id);
    Optional<User> findById(String id);
    Optional<User> findByUserId(int userId);
}
