package com.idle.gaza.api.service;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.GuideThema;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class GuideServiceTest {


    @Autowired
    private GuideService guideService;

    @Test
    @Transactional
    void guideSearch() {

        //when
        List<Guide> guideList = guideService.guideSearch();

        //then
        log.info("guide List size = " + guideList.size());

    }

    @Test
    @Transactional
    void famousGuideSearch() {
    }

    @Test
    @Transactional
    void guideDetailSearch() {
        //given
        int guideId = 1;

        //when
        Guide guide = guideService.guideDetailSearch(guideId);
        List<GuideThema> thema = guide.getGuideThemaList();

        //then
        log.info("thema name = " + thema.get(0).getThemaCode());
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
        guide.setId("ssafy");
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

    @Test
    void consultDateRegister() {
    }

    @Test
    void consultDateDelete() {
    }

    @Test
    void consultTimeRegister() {
    }

    @Test
    void tourThemaRegister() {
        //given
        int guideId = 1;
        String code = "먹방";

        //when
        int result = guideService.tourThemaRegister(guideId, code);

        //then
        if(result == 0) log.info("fail");
        else log.info("register");
    }

    @Test
    void tourThemaDelete() {
        //given

        //when

        //then

    }



}