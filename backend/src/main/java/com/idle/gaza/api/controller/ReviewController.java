package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.ReviewCreatePostRequest;
import com.idle.gaza.api.service.ReservationService;
import com.idle.gaza.api.service.ReviewService;
import com.idle.gaza.common.model.response.BaseResponseBody;
import com.idle.gaza.db.entity.Review;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getReviewsByUser(@PathVariable int userID){
        List<Review> reviews = reviewService.getReviewsByUser(userID);
        return new ResponseEntity<List<?>>(reviews, HttpStatus.OK);
    }

    @GetMapping("/guide/{guideId}")
    public ResponseEntity<?> getReviewsByGuide(@PathVariable int guideId){
        List<Review> reviews = reviewService.getReviewsByGuide(guideId);
        return new ResponseEntity<List<?>>(reviews, HttpStatus.OK);
    }
}
