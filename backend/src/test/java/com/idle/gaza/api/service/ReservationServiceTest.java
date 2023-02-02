package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.entity.User;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
class ReservationServiceTest {

    @Autowired
    ReservationService reservationService = new ReservationServiceImpl();

    @Test
    void createReservation() {
        //given
        ReservationCreatePostRequest reservation = new ReservationCreatePostRequest();

        reservation.setUserId(1);
        reservation.setGuideId(1);
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
    void getReservationListByUser() {
        //given
        int userId = 1;
        //when
        //then
        //Assertions.assertEquals(list.size(), 1);
    }

    @Test
    void getReservationListByGuide() {
        //given
        int guideId = 1;
        //when
        //then
        //Assertions.assertEquals(list.size(), 1);
    }
}