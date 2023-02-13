package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.GuideThema;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface GuideThemaRepository extends JpaRepository<GuideThema, Integer> {

    @Transactional
    void deleteByThemaId(int themaId);

    List<GuideThema> findByGuide(Guide guide);

}
