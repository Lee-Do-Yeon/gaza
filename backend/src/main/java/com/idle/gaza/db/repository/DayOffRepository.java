package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DayOffRepository extends JpaRepository<DayOff, Integer> {

    Optional<DayOff> findDayOffByDayOffId(int dayId);

}
