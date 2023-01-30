package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 예약 모델 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByGuideId_GuideId(int guideId);
    List<Reservation> findByUserId_UserId(int userId);
}
