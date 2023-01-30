package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.repository.ReservationRepository;
import com.idle.gaza.db.repository.ReservationRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationRepositorySupport reservationRepositorySupport;

    @Override
    public Reservation createReservation(ReservationCreatePostRequest reservationInfo) {
        Reservation reservation = Reservation.builder()
                .userId(reservationInfo.getUserId())
                .guideId(reservationInfo.getGuideId())
                .consultingDate(reservationInfo.getConsultingDate())
                .reservationDate(reservationInfo.getReservationDate())
                .travleStartDate(reservationInfo.getTravleStartDate())
                .travleEndDate(reservationInfo.getTravleEndDate())
                .numberOfPeople(reservationInfo.getNumberOfPeople())
                .withChildren(reservationInfo.getWithChildren())
                .withElderly(reservationInfo.getWithElderly())
                .withDisabled(reservationInfo.getWithDisabled())
                .note(reservationInfo.getNote())
                .build();
        return reservationRepository.save(reservation);
    }


}
