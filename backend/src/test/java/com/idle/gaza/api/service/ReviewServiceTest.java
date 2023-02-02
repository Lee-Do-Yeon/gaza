package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.entity.Review;
import com.idle.gaza.db.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;

@Slf4j
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class ReviewServiceTest {

    private ReviewRepository reviewRepository = Mockito.mock(ReviewRepository.class);
    private ReviewServiceImpl reviewService;

//    @BeforeEach
//    public void setUpTest() {
//        reviewService = new ReviewServiceImpl(reviewRepository);
//    }

    @Test
    public void 대기중_예약_리뷰작성() throws Exception {
        // given

        // when

        // then
    }

    @Test
    public void 리뷰작성() throws Exception {
        // given
//        Reservation reservation = new Reservation();
//        reservation.setConsultingDate();
//        reservation.setGuideId();
//        reservation.setNumberOfPeople();
//        reservation.setReservationId();
//        reservation.setTravelEndDate();
//        reservation.setTravelStartDate();
//        reservation.setUserId();

        // when

        // then
    }

    @Test
    public void 작성자별_리뷰리스트_조회() throws Exception {
        // given

        // when

        // then
    }

    @Test
    public void 가이드별_리뷰리스트_조회() throws Exception {
        // given

        // when

        // then
    }


//
//    @Test
//    void test(){
//        log.info("아아아ㅏ아아");
//    }
//
//    @Test
//    void getReviewByIdTest() {
//        Review givenReview = new Review(
//                999, null, "만족해요.", Timestamp.valueOf("2023-02-01 15:03:23"), 5);
//
//        Mockito.when(reviewRepository.findById(999))
//                .thenReturn(Optional.of(givenReview));
//
//        Optional<Review> reviewOp = reviewService.getReviewById(999);
//        Review review = null;
//        if(reviewOp.isPresent()){
//            review = reviewOp.get();
//        }
//        Assertions.assertEquals(review.getReviewId(), givenReview.getReviewId());
//        Assertions.assertEquals(review.getReservationId(), givenReview.getReservationId());
//        Assertions.assertEquals(review.getContent(), givenReview.getContent());
//        Assertions.assertEquals(review.getCreatedDate(), givenReview.getCreatedDate());
//        Assertions.assertEquals(review.getScore(), givenReview.getScore());
//
//        verify(reviewRepository).findById(999);
//    }
//
//    @Test
//    void getReviewsByGuide(){
//        List<Review> list = reviewService.getReviewsByGuide(1);
//        log.info("개수: "+list.size());
//        for(int i=0; i<list.size(); i++){
//            log.info(i+"번 : " + list.get(i));
//        }
//
//    }

}