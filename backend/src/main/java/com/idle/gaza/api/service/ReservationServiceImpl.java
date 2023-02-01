package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.entity.User;
import com.idle.gaza.db.repository.GuideRepository;
import com.idle.gaza.db.repository.ReservationRepository;
import com.idle.gaza.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *  예약 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GuideRepository guideRepository;

    @Override
    public Reservation createReservation(ReservationCreatePostRequest reservationInfo) {
        Optional<User> userOptional = userRepository.findByUserId(reservationInfo.getUserId());
        User user = null;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }

        Optional<Guide> guideOptional = guideRepository.findGuideByGuideId(reservationInfo.getGuideId());
        Guide guide = null;
        if(guideOptional.isPresent()){
            guide = guideOptional.get();
        }

        Reservation reservation = Reservation.builder()
                .userId(user)
                .guideId(guide)
                .consultingDate(reservationInfo.getConsultingDate())
                .reservationDate(new Timestamp(System.currentTimeMillis()))
                .travelStartDate(reservationInfo.getTravelStartDate())
                .travelEndDate(reservationInfo.getTravelEndDate())
                .numberOfPeople(reservationInfo.getNumberOfPeople())
                .withChildren(reservationInfo.getWithChildren())
                .withElderly(reservationInfo.getWithElderly())
                .withDisabled(reservationInfo.getWithDisabled())
                .note(reservationInfo.getNote())
                .stateCode("RE02")
                .build();

        return reservationRepository.save(reservation);
    }

    @Override
    public void cancelReservation(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> getReservationListByGuide(int guideId) {
        return reservationRepository.findByGuideId_GuideId(guideId);
    }

    @Override
    public List<Reservation> getReservationListByUser(int userId) {
        return reservationRepository.findByUserId_UserId(userId);
    }

}
