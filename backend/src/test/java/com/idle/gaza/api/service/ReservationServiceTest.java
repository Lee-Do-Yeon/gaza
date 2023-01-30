package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.entity.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReservationServiceTest {

    @Autowired
    ReservationService reservationService = new ReservationServiceImpl();

    @Test
    void 예약_생성_성공() {
        //given
        ReservationCreatePostRequest reservation = new ReservationCreatePostRequest();
        
        UserDto user = UserDto.userBuilder()
                .userId("ssafy")
                .userPw("1234")
                .userNm("김싸피")
                .userSt("상태")
                .build();

        Guide guide = Guide.builder()
                .guideId()
                .build();

        reservation.setUserId(user);
        reservation.setGuideId(guide);
        reservation.setReservationDate(new Timestamp(System.currentTimeMillis()));
        reservation.setConsultingDate(new Timestamp(System.currentTimeMillis()));
        reservation.setTravleStartDate(new Timestamp(System.currentTimeMillis()));
        reservation.setTravleEndDate(new Timestamp(System.currentTimeMillis()));
        reservation.setNumberOfPeople(3);
        reservation.setWithElderly(1);
        reservation.setWithChildren(0);
        reservation.setWithDisabled(0);
        reservation.setNote("특이사항");

        //when
        Reservation result = reservationService.createReservation(reservation);

        //then


    }
}