package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.TravelRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRouteRepository extends JpaRepository<TravelRoute, Integer> {
    @Query(value="select * from travel_route where reservation_id = :reservationId", nativeQuery = true)
    List<TravelRoute> findByRerservationId_ReservationId(Integer reservationId);
}
