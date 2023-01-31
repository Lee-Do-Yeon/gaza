package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.User;
import jdk.internal.joptsimple.internal.OptionNameMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String id);

}
