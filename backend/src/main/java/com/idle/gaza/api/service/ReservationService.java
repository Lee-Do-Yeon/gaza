package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.db.entity.Reservation;

/**
 *	예약 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface ReservationService {
    Reservation createReservation(ReservationCreatePostRequest reservationInfo);
}
