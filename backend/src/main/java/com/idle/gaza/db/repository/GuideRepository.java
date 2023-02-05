package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Guide;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
* 가이드 관련 JPA Query Method 인터페이스 정의
* */
@Repository
public interface GuideRepository extends JpaRepository<Guide, Integer> {

    /* 전체 가이드 회원 조회 */
    List<Guide> findBy();

    /* 가이드 상세 조회 */
    Optional<Guide> findGuideByGuideId(int guideId);

    /* 해당 회원이 가이드인지 조회 */
    @Query(value = "SELECT *  FROM guide as g WHERE g.user_id=:userId", nativeQuery = true)
    Optional<Guide> findGuideByUser(@Param("userId") int userId);

    /* 예약순 조회 */
    @Query(value = "select * from guide left join ( select guide_id, count(guide_id) from reservation group by guide_id order by count(*)) reservation on reservation.guide_id=guide.guide_id order by reservation.guide_id", nativeQuery = true)
    List<Guide> findOrderByMaxReservation();
}
