package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.DayOffPostRequest;
import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.request.LocationPostRequest;
import com.idle.gaza.api.request.TimeRegisterPostRequest;
import com.idle.gaza.api.response.GuideResponse;
import com.idle.gaza.api.service.GuideService;
import com.idle.gaza.db.entity.Guide;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Api(value = "가이드 API", tags = {"Guide"})
@RestController
@RequestMapping("/guides")
@Log4j2
public class GuideController {

    @Autowired
    GuideService guideService;

    @Value("${spring.servlet.multipart.location}")
    String rootPath;

    //가이드 등록
    @PostMapping()
    @ApiOperation(value = "가이드 등록", notes = "가이드를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> guideRegister(@RequestBody GuideRegisterPostRequest guide, @RequestParam("uploadFile") MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            //make upload folder
            String uploadPath = "/guide/";
            File uploadFilePath = new File(rootPath, uploadPath);

            if(!uploadFilePath.exists()){
                uploadFilePath.mkdirs();
            }
            String fileName = multipartFile.getOriginalFilename();//저장될 파일명
            File saveFile = new File(uploadFilePath, fileName);

            log.info("file name = " + fileName);
            try {
                multipartFile.transferTo(saveFile);
                guide.setPicture(fileName);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        int result = guideService.guideRegister(guide);

        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //////////////////////가이드 조회///////////////////////////

    //가이드 전체 조회
    @GetMapping()
    @ApiOperation(value = "가이드 전체 조회", notes = "가이드 전체 목록을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> guideSearch() {
        List<Guide> guideList = guideService.guideSearch();

        if (guideList == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(guideList, HttpStatus.OK);
    }

    //인기 가이드 조회
    @GetMapping("/popular")
    @ApiOperation(value = "인기 가이드 조회", notes = "인기 가이드 목록을 조회한다.(예약 많은 순으로 정렬)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> popularGuideSearch() {
        try{
            List<GuideResponse> guideList = guideService.famousGuideSearch();
            return new ResponseEntity<>(guideList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    //가이드 상세 프로필 조회
    @GetMapping("/{guideId}")
    @ApiOperation(value = "가이드 상세 프로필 조회", notes = "가이드 프로필을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> guideProfileSearch(@PathVariable @ApiParam(value = "가이드PK", required = true) int guideId) {
        Guide guide = guideService.guideDetailSearch(guideId);

        if (guide == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(guide, HttpStatus.OK);
    }


    @PostMapping("/location")
    @ApiOperation(value = "추천 장소 등록", notes = "추천 장소를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> locationRegister(@RequestBody LocationPostRequest location, @RequestParam(name = "uploadFile") MultipartFile multipartFile) {

        if (!multipartFile.isEmpty()) {
            //make upload folder
            String uploadPath = "/location/";
            File uploadFilePath = new File(rootPath, uploadPath);

            if(!uploadFilePath.exists()){
                uploadFilePath.mkdirs();
            }
            String fileName = multipartFile.getOriginalFilename();//저장될 파일명
            File saveFile = new File(uploadFilePath, fileName);
            
            log.info("file name = " + fileName);
            try {
                multipartFile.transferTo(saveFile);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        int result = guideService.locationRegister(location);
        if(result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/location")
    @ApiOperation(value = "추천 장소 삭제", notes = "추천 장소를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> locationDelete(@RequestParam Map<String, String> map) {
        int guideId = Integer.parseInt(map.get("guideId"));
        int recommendId = Integer.parseInt(map.get("recommendId"));

        //파일이 존재한다면 기존 경로에서 파일 삭제
        String existFile = guideService.findExistFile(recommendId);
        if(existFile != null){
            String existPath = new String(rootPath + "/" + "location" + "/" + existFile);
            File file = new File(existPath);
            log.info("exist file path = " + file);

            if(file.exists()){
                log.info("delete file");
                file.delete();
            }
        }

        guideService.locationDelete(guideId, recommendId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/location")
    @ApiOperation(value = "추천 장소 수정", notes = "추천 장소를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> locationUpdate(@RequestBody LocationPostRequest location, @RequestParam("uploadFile") MultipartFile multipartFile) {
        //파일이 존재한다면 기존 경로에서 파일 삭제
        String existFile = guideService.findExistFile(location.getRecommendId());

        if(existFile != null){
            String existPath = new String(rootPath + "/" + "loc" + "/" + existFile);
            File file = new File(existPath);
            log.info("exist file path = " + file);

            if(file.exists()){
                log.info("delete file");
                file.delete();
            }
        }
        String uploadPath = "/location/";
        File uploadFilePath = new File(rootPath, uploadPath);

        if(!uploadFilePath.exists()){
            uploadFilePath.mkdirs();
        }
        String fileName = multipartFile.getOriginalFilename();
        File saveFile = new File(uploadFilePath, fileName);
        log.info("file name = " + fileName);
        try {
            multipartFile.transferTo(saveFile);
            location.setPicture(fileName);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        int result = guideService.locationUpdate(location);
        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    /////////////////////여행 테마 기능///////////////////////////

    @PutMapping("/thema/{guideId}")
    @ApiOperation(value = "여행 테마 등록", notes = "여행 테마를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> tourThemaRegister(@PathVariable @ApiParam(value = "가이드PK", required = true) int guideId, @RequestParam(name = "thema", required = false) @ApiParam(value = "테마코드", required = true) String themaCode) {
        int result = guideService.tourThemaRegister(guideId, themaCode);

        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/thema/{guideId}")
    @ApiOperation(value = "여행 테마 삭제", notes = "가이드가 등록한 여행 테마를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> tourThemaDelete(@PathVariable @ApiParam(value = "가이드PK", required = true) int guideId, @RequestParam int themaId) {
        int result = guideService.tourThemaDelete(guideId, themaId);

        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    //////////////////상담 시간 관리////////////////////////

    @PostMapping("/day")
    @ApiOperation(value = "상담 불가능한 날짜 등록", notes = "가이드는 상담 불가능한 날짜를 등록한다. String userId와 LocalDate day을 받음")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> dayRegister(@RequestBody DayOffPostRequest dayOff) {

        int result = guideService.consultDateRegister(dayOff.getUserId(), dayOff.getDay());
        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/day")
    @ApiOperation(value = "상담 불가능한 날짜 취소", notes = "가이드는 상담 불가능한 날짜를 취소한다. 날짜 형식은 2022-01-20")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> dayDelete(@RequestParam @ApiParam(value = "key는 userId와 dayId의 이름으로 받음") Map<String, String> map) {
        String userId = map.get("userId");
        int day = Integer.parseInt(map.get("dayId"));

        int result = guideService.consultDateDelete(userId, day);
        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/time")
    @ApiOperation(value = "상담 불가능한 시간대 등록", notes = "가이드는 상담 불가능한 시작, 종료 시간을 등록한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> timeDelete(@RequestBody TimeRegisterPostRequest time) {
        int result = guideService.consultTimeRegister(time.getStartTime(), time.getEndTime(), time.getUserId());

        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
