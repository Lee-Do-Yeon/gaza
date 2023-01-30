package com.idle.gaza.api.controller;

import com.idle.gaza.api.service.GuideService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "가이드 API", tags = {"Guide"})
@RestController
@RequestMapping("/guides")
@Log4j2
public class GuideController {

    private GuideService guideService;

    @Autowired
    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    //////////////////////가이드 조회///////////////////////////

    //가이드 조회
    @GetMapping("/")
    public ResponseEntity<?> localGuideSearch(){

        return null;
    }

    //인기 가이드 조회
    public ResponseEntity<?> famousGuideSearch(){
        return null;
    }

    //가이드 프로필 조회
    public ResponseEntity<?> guideProfileSearch(){
        return null;
    }



    @PostMapping()
    @ApiOperation(value = "추천 장소 등록", notes = "추천 장소를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> locationRegister(){
        return null;
    }

 @DeleteMapping("/location/{userId}/{recommendId}")
    @ApiOperation(value = "추천 장소 삭제", notes = "추천 장소를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> locationDelete(@PathVariable String userId, @PathVariable String recommendId){

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/location/{userId}/{recommendId}")
    @ApiOperation(value = "추천 장소 수정", notes = "추천 장소를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> locationUpdate(@PathVariable String userId, @PathVariable String recommendId){
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    /////////////////////여행 테마 기능///////////////////////////

    @PutMapping("/theme/{userId}")
    @ApiOperation(value = "여행 테마 등록", notes = "여행 테마를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> travelThemeRegister(){
        return null;
    }

    @DeleteMapping("/theme/{userId}")
    @ApiOperation(value = "여행 테마 삭제", notes = "가이드가 등록한 여행 테마를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> travelThemeDelete(){
        return null;
    }



}
