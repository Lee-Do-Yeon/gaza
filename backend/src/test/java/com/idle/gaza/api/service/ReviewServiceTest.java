package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.Review;
import com.idle.gaza.db.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;

@Slf4j
class ReviewServiceTest {
    private ReviewRepository reviewRepository = Mockito.mock(ReviewRepository.class);
    private ReviewServiceImpl reviewService;

    @BeforeEach
    public void setUpTest() {
        reviewService = new ReviewServiceImpl(reviewRepository);
    }

    @Test
    void test(){
        log.info("아아아ㅏ아아");
    }

    @Test
    void getReviewByIdTest() {
        Review givenReview = new Review(
                999, null, "만족해요.", Timestamp.valueOf("2023-02-01 15:03:23"), 5);

        Mockito.when(reviewRepository.findById(999))
                .thenReturn(Optional.of(givenReview));

        Optional<Review> reviewOp = reviewService.getReviewById(999);
        Review review = null;
        if(reviewOp.isPresent()){
            review = reviewOp.get();
        }
        Assertions.assertEquals(review.getReviewId(), givenReview.getReviewId());
        Assertions.assertEquals(review.getReservationId(), givenReview.getReservationId());
        Assertions.assertEquals(review.getContent(), givenReview.getContent());
        Assertions.assertEquals(review.getCreatedDate(), givenReview.getCreatedDate());
        Assertions.assertEquals(review.getScore(), givenReview.getScore());

        verify(reviewRepository).findById(999);
    }

    @Test
    void getReviewsByGuide(){
        List<Review> list = reviewService.getReviewsByGuide(1);
        log.info("개수: "+list.size());
        for(int i=0; i<list.size(); i++){
            log.info(i+"번 : " + list.get(i));
        }

    }

}