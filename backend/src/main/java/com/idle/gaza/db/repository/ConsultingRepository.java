package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Consulting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultingRepository extends JpaRepository<Consulting, Integer> {
    Optional<Consulting> findByReservationId(Integer reservationId);
}
