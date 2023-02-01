package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.ReviewCreatePostRequest;
import com.idle.gaza.api.service.ReservationService;
import com.idle.gaza.api.service.ReviewService;
import com.idle.gaza.common.model.response.BaseResponseBody;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<? extends BaseResponseBody> writeReview(@RequestBody ReviewCreatePostRequest reviewInfo){
        reviewService.writeReview(reviewInfo);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }
}
