package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
    Guide findGuideByUser(User user);

}
