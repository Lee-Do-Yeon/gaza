package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.User;
import com.idle.gaza.db.repository.GuideRepository;
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
}