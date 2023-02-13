package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.ReviewCreatePostRequest;
import com.idle.gaza.api.response.ReviewResponse;
import com.idle.gaza.api.service.ReviewServiceImpl;
import com.idle.gaza.common.model.response.BaseResponseBody;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(value = "리뷰 API", tags = {"Review"})
@RestController
@RequestMapping("/reviews")
@Slf4j
public class ReviewController {

    @Autowired
    ReviewServiceImpl reviewService;

    @PostMapping
    @ApiOperation(value = "리뷰 작성", notes = "완료된 상담에 대해 리뷰를 작성한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> writeReview(@RequestBody @ApiParam(value="리뷰 작성 정보", required = true) ReviewCreatePostRequest reviewInfo){
        try{
            reviewService.writeReview(reviewInfo);
        }catch (Exception e){
            return ResponseEntity.status(500).body(BaseResponseBody.of(500, "fail"));
        }
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "리뷰 조회 (작성자)", notes = "작성한 리뷰 리스트를 볼 수 있다.")
    public ResponseEntity<?> getReviewsByUser(@PathVariable String userId){
        List<ReviewResponse> reviews = reviewService.getReviewsByUser(userId);
        return new ResponseEntity<List<?>>(reviews, HttpStatus.OK);
    }

    @GetMapping("/guide/{guideId}")
    @ApiOperation(value = "리뷰 조회 (가이드)", notes = "가이드에게 달린 리스트를 볼 수 있다.")
    public ResponseEntity<?> getReviewsByGuide(@PathVariable int guideId){
        List<ReviewResponse> reviews = reviewService.getReviewsByGuide(guideId);
        return new ResponseEntity<List<?>>(reviews, HttpStatus.OK);
    }
}
