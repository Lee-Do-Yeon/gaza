package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.service.GuideService;
import com.idle.gaza.db.entity.DayOff;
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

import java.time.LocalTime;
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
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> guideRegister(@RequestBody GuideRegisterPostRequest guide, @RequestParam MultipartFile uploadFile){

        return null;
    }

    //////////////////////가이드 조회///////////////////////////

    //가이드 전체 조회
    @GetMapping("/")
    @ApiOperation(value = "가이드 전체 조회", notes = "가이드 전체 목록을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> guideSearch() {

        return null;
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
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> guideProfileSearch(@PathVariable int guideId) {
        return null;
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

    @DeleteMapping("/location/{userId}/{recommendId}")
    @ApiOperation(value = "추천 장소 삭제", notes = "추천 장소를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> locationDelete(@PathVariable String userId, @PathVariable int recommendId) {

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

    @PutMapping("/theme/{userId}")
    @ApiOperation(value = "여행 테마 등록", notes = "여행 테마를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> tourThemeRegister(@PathVariable String userId, @RequestParam(name = "tourTheme" ,required = false) List<String> travelList) {
        return null;
    }

    @DeleteMapping("/theme/{userId}")
    @ApiOperation(value = "여행 테마 삭제", notes = "가이드가 등록한 여행 테마를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> tourThemeDelete(@PathVariable String userId, @RequestParam int tourId) {
        return null;
    }


    //////////////////상담 시간 관리////////////////////////

    @PostMapping("/day")
    @ApiOperation(value = "상담 불가능한 날짜 등록", notes = "가이드는 상담 불가능한 날짜를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> dayRegister(@RequestParam("date") List<DayOff> dayOff){

        for (DayOff day : dayOff) {
            guideService.consultDateRegister(day);
        }

        return null;
    }

    @DeleteMapping("/day/{guideId}")
    @ApiOperation(value = "상담 불가능한 날짜 취소", notes = "가이드는 상담 불가능한 날짜를 취소한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> dayWithdraw(@PathVariable int guideId){
        return null;
    }



    @PostMapping("/time/{guideId}")
    @ApiOperation(value = "상담 불가능한 시간대 등록", notes = "가이드는 상담 불가능한 시작, 종료 시간을 등록한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> timeWithdraw(LocalTime startTime, LocalTime endTime){ return null; }

}
