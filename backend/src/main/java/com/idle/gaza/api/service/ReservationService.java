package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.db.entity.Reservation;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 *	예약 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface ReservationService {
    Reservation createReservation(ReservationCreatePostRequest reservationInfo);
    void cancelReservation(int reservationId);
    List<Reservation> getReservationListByGuide(int guideId);
    List<Reservation> getReservationListByUser(int userId);
    List<Timestamp> getImpossibleTime(int guideId, Timestamp selectedDate);
}
