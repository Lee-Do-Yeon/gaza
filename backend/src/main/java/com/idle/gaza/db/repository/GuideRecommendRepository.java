package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.GuideRecommendLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 가이드 추천 장소 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의
 */
@Repository
public interface GuideRecommendRepository extends JpaRepository<GuideRecommendLocation, Integer>{

    Optional<Guide> findByGuideId(Integer guideId);

}
