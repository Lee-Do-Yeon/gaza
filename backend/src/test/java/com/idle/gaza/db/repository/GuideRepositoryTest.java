package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class GuideRepositoryTest {

    @Autowired
    private GuideRepository guideRepository;

    @Test
    void findBy() {
        //when
        List<Guide> guideList = guideRepository.findBy();

        //then
        for (Guide guide: guideList) {
            log.info("guide = " + guide);
        }
    }

    @Test
    void findGuideByGuideId() {
        //given
        int id = 1;

        //when
        Optional<Guide> guide = guideRepository.findGuideByGuideId(id);

        //then
        Assertions.assertTrue(guide.isPresent());
        Assertions.assertEquals(id, guide.get().getGuideId());

    }

    @Test
    @Transactional
    void findGuideByUser() {
        //given
        int userId = 2;

        //when
        Optional<Guide> guide = guideRepository.findGuideByUser(userId);

        //then
        Assertions.assertTrue(guide.isPresent());
        Assertions.assertEquals(guide.get().getUser().getUserId(), userId);
    }
}