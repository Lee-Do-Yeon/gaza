package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 예약 모델 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    //JpaRepository<엔티티 클래스이름 , ID 필드 타입>
}
