package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReservationServiceTest {

    @Autowired
    ReservationService reservationService = new ReservationServiceImpl();

    @Test
    void 예약_생성_성공() {
        //given
        ReservationCreatePostRequest reservation = new ReservationCreatePostRequest();

        //reservation.setUserId(user);
        //reservation.setGuideId(guide);
        reservation.setReservationDate(new Timestamp(System.currentTimeMillis()));
        reservation.setConsultingDate(new Timestamp(System.currentTimeMillis()));
        reservation.setTravelStartDate(new Timestamp(System.currentTimeMillis()));
        reservation.setTravelEndDate(new Timestamp(System.currentTimeMillis()));
        reservation.setNumberOfPeople(3);
        reservation.setWithElderly(1);
        reservation.setWithChildren(0);
        reservation.setWithDisabled(0);
        reservation.setNote("특이사항");

        //when
        Reservation result = reservationService.createReservation(reservation);

        //then


    }

    @Test
    void 예약내역_조회_회원() {
        //given
        int userId = 1;
        //when
        List<Reservation> list = reservationService.getReservationListByUser(userId);
        //then
        Assertions.assertEquals(list.size(), 1);
    }

    @Test
    void 예약내역_조회_가이드() {
        //given
        int guideId = 1;
        //when
        List<Reservation> list = reservationService.getReservationListByGuide(guideId);
        //then
        Assertions.assertEquals(list.size(), 1);
    }
}