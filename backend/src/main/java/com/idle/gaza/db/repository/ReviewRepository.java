package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByUserId_UserId(int userId);
    List<Review> findByGuideId_GuideId(int guideId);
}
