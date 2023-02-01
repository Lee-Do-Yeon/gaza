package com.idle.gaza.db.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class ReservationRepositoryTest {
    @Autowired
    ReservationRepository reservationRepository;
    @Test
    void getImpossibleTime() {
        List<Timestamp> list = reservationRepository.getImpossibleTime(1, new Timestamp(System.currentTimeMillis()));
        log.debug("개수" + list.size());
        for(int i=0; i<list.size(); i++){
            log.debug(i+"번 : " + list.get(i));
        }
    }
}