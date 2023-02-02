package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.GuideThema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideThemaRepository extends JpaRepository<GuideThema, Integer> {

    void deleteGuideThemaByThemaId(int themaId);

}
