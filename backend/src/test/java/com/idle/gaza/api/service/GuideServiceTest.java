package com.idle.gaza.api.service;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.User;
import com.idle.gaza.db.repository.GuideRepository;
import jdk.vm.ci.meta.Local;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class GuideServiceTest {


    @Autowired
    private GuideService guideService;

    @Test
    void guideSearch() {

        //when
        List<Guide> guideList = guideService.guideSearch();

        //then
        log.info("guide List size = " + guideList.size());

    }

    @Test
    void famousGuideSearch() {
    }

    @Test
    @Transactional
    void guideDetailSearch() {
        //given
        int userId = 2;
        int guideId = 1;

        //when
        Guide guide = guideService.guideDetailSearch(userId);

        //then
        Assertions.assertEquals(guide.getGuideId(), guideId);
    }

    @Test
    void locationRegister() {
    }

    @Test
    void locationDelete() {
    }

    @Test
    void locationUpdate() {
    }

    @Test
    void guideRegister() {
        //given
        GuideRegisterPostRequest guide = new GuideRegisterPostRequest();
        int userId = 1;
        guide.setCity("Seoul");
        guide.setCloseTimeEnd(LocalTime.now());
        guide.setIntroduction("i'm from south korea");
        guide.setLicense(0);
        guide.setUserId(userId);
        guide.setCloseTimeStart(LocalTime.now());
        guide.setOnlineIntroduction("hello my name is kim");
        guide.setCountry("south korea");
        guide.setPicture("test.png");

        //when
        guideService.guideRegister(guide);
        Guide searchGuide =  guideService.guideDetailSearch(userId);

        //then
        Assertions.assertEquals(userId, searchGuide.getUser().getUserId());
    }


}