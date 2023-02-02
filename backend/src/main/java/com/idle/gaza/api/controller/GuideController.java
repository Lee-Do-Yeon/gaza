package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.request.TimeRegisterPostRequest;
import com.idle.gaza.api.service.GuideService;
import com.idle.gaza.db.entity.Guide;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Api(value = "가이드 API", tags = {"Guide"})
@RestController
@RequestMapping("/guides")
@Log4j2
public class GuideController {

    @Autowired
    GuideService guideService;


    //가이드 등록
    @PostMapping()
    @ApiOperation(value = "가이드 등록", notes = "가이드를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message="사용자 없음")
    })
    public ResponseEntity<?> guideRegister(@RequestBody GuideRegisterPostRequest guide, @RequestParam MultipartFile uploadFile){

        int result = guideService.guideRegister(guide);

        if(result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //////////////////////가이드 조회///////////////////////////

    //가이드 전체 조회
    @GetMapping("/")
    @ApiOperation(value = "가이드 전체 조회", notes = "가이드 전체 목록을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message="사용자 없음")
    })
    public ResponseEntity<?> guideSearch() {
        List<Guide> guideList = guideService.guideSearch();

        if(guideList==null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(guideList, HttpStatus.OK);
    }

    //인기 가이드 조회
    @PostMapping("/popular")
    @ApiOperation(value = "인기 가이드 조회", notes = "인기 가이드 목록을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> popularGuideSearch() {
        return null;
    }


    //가이드 상세 프로필 조회
    @GetMapping("/{guideId}")
    @ApiOperation(value = "가이드 상세 프로필 조회", notes = "가이드 프로필을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message="사용자 없음")
    })
    public ResponseEntity<?> guideProfileSearch(@PathVariable int guideId) {
        Guide guide = guideService.guideDetailSearch(guideId);

        if(guide == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(guide, HttpStatus.OK);
    }


    @PostMapping("/location/{userId}")
    @ApiOperation(value = "추천 장소 등록", notes = "추천 장소를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> locationRegister(@PathVariable String userId, @RequestParam MultipartFile uploadFile) {
        return null;
    }

    @DeleteMapping("/location/{guideId}/{recommendId}")
    @ApiOperation(value = "추천 장소 삭제", notes = "추천 장소를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> locationDelete(@PathVariable int guideId, @PathVariable int recommendId) {

        guideService.locationDelete(guideId, recommendId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/location/{userId}/{recommendId}")
    @ApiOperation(value = "추천 장소 수정", notes = "추천 장소를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> locationUpdate(@PathVariable String userId, @PathVariable int recommendId, @RequestParam MultipartFile uploadFile) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    /////////////////////여행 테마 기능///////////////////////////

    @PutMapping("/thema/{guideId}")
    @ApiOperation(value = "여행 테마 등록", notes = "여행 테마를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message="사용자 없음")
    })
    public ResponseEntity<?> tourThemaRegister(@PathVariable int guideId, @RequestParam(name = "thema" ,required = false) String themaName) {
        int result = guideService.tourThemaRegister(guideId, themaName);

        if(result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/thema/{guideId}")
    @ApiOperation(value = "여행 테마 삭제", notes = "가이드가 등록한 여행 테마를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message="사용자 없음")
    })
    public ResponseEntity<?> tourThemaDelete(@PathVariable int guideId, @RequestParam int themaId) {
        int result = guideService.tourThemaDelete(guideId, themaId);

        if(result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    //////////////////상담 시간 관리////////////////////////

    @PostMapping("/day/{userId}")
    @ApiOperation(value = "상담 불가능한 날짜 등록", notes = "가이드는 상담 불가능한 날짜를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message="사용자 없음")
    })
    public ResponseEntity<?> dayRegister(@PathVariable String userId, @RequestParam("date") List<LocalDate> dayOff){

        for (LocalDate day : dayOff) {
            int result = guideService.consultDateRegister(userId, day);
            if(result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/day/{userId}")
    @ApiOperation(value = "상담 불가능한 날짜 취소", notes = "가이드는 상담 불가능한 날짜를 취소한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> dayDelete(@PathVariable String userId){

        return null;
    }



    @PostMapping("/time")
    @ApiOperation(value = "상담 불가능한 시간대 등록", notes = "가이드는 상담 불가능한 시작, 종료 시간을 등록한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code=204, message="NO CONTENT")
    })
    public ResponseEntity<?> timeDelete(@RequestBody TimeRegisterPostRequest time){
        int result = guideService.consultTimeRegister(time.getStartTime(), time.getEndTime(), time.getUserId());

        if(result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
