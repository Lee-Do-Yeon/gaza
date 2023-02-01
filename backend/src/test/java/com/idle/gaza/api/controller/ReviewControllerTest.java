package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.ReviewCreatePostRequest;
import com.idle.gaza.api.service.ReviewServiceImpl;
import com.idle.gaza.db.entity.Review;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ReviewController.class)
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReviewServiceImpl reviewService;

    @Test
    @DisplayName("review 데이터 생성 테스트")
    void writeReview() throws Exception {
    }

    @Test
    void getReviewsByUser() {
    }

    @Test
    void getReviewsByGuide() {
    }
}