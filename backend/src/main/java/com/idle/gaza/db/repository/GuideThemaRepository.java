package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.GuideThema;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface GuideThemaRepository extends JpaRepository<GuideThema, Integer> {

    @Transactional
    void deleteByThemaId(int themaId);

}
