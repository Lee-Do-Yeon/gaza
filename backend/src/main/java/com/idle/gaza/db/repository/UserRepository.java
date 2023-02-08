package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.GuideDocument;
import com.idle.gaza.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user as u WHERE id=:id AND state_code!='US5'", nativeQuery = true)
    Optional<User> login(@Param("id") String id);
    @Query(value = "SELECT g.* FROM user as u, guide_document as g WHERE g.user_id = u.user_id and u.state_code='US2'", nativeQuery = true)
    Optional<List<GuideDocument>> searchGuideRegisterList();
    Optional<User> findById(String id);
    Optional<User> findByUserId(int userId);
}
