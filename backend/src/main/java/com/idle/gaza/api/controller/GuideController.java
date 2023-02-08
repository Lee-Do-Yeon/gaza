package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.DayOffPostRequest;
import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.request.LocationPostRequest;
import com.idle.gaza.api.request.TimeRegisterPostRequest;
import com.idle.gaza.api.response.GuideResponse;
import com.idle.gaza.api.response.LocationResponse;
import com.idle.gaza.api.service.GuideService;
import com.idle.gaza.common.util.S3Uploader;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Api(value = "가이드 API", tags = {"Guide"})
@RestController
@RequestMapping("/guides")
@Log4j2
public class GuideController {

    @Autowired
    GuideService guideService;

    @Value("${cloud.aws.directory}")
    String rootPath;

    @Autowired
    private S3Uploader s3Uploader;


    @GetMapping(value = "/search")
    @ApiOperation(value = "검색 창으로 가이드 조회", notes = "나라 또는 도시를 통해 가이드를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> search(@RequestParam String searchName){
        List<GuideResponse> searchList = guideService.guideSearchBar(searchName);

        if(searchList.size() == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        log.info("search size = " + searchList.size());
        return new ResponseEntity<>(searchList, HttpStatus.OK);
    }


    //가이드 등록
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "가이드 등록", notes = "가이드를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> guideRegister(@RequestPart GuideRegisterPostRequest guide, @RequestPart(value = "uploadFile", required = false) MultipartFile multipartFile) {
        log.info("guide = " + guide.toString());
        if (!multipartFile.isEmpty()) {
            String uploadPath = rootPath + "/" + "guide" + "/" + "picture" + "/";

            String fileName = multipartFile.getOriginalFilename();//원본 파일명
            String uploadFileName = UUID.randomUUID().toString() + "_" + fileName;
            log.info("file name = " + uploadFileName);

            try {
                s3Uploader.upload(multipartFile, uploadPath+ uploadFileName);
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
        List<GuideResponse> guideList = guideService.guideSearch();

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
        try {
            List<GuideResponse> guideList = guideService.famousGuideSearch();
            return new ResponseEntity<>(guideList, HttpStatus.OK);
        } catch (Exception e) {
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
        GuideResponse guide = guideService.guideDetailSearch(guideId);

        if (guide == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(guide, HttpStatus.OK);
    }

    ////////////////////////추천 장소/////////////////////////////

    @PostMapping(value = "/location", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "추천 장소 등록", notes = "추천 장소를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> locationRegister(@RequestPart(name = "location") LocationPostRequest location, @RequestPart(name = "uploadFile", required = false) MultipartFile multipartFile) {
        log.info("location = " + location.toString());

        if (!multipartFile.isEmpty()) {
            String uploadPath = rootPath + "/" + "location" + "/" + "picture" + "/";

            String fileName = multipartFile.getOriginalFilename();//원본 파일명
            String uploadFileName = UUID.randomUUID().toString() + "_" + fileName;
            log.info("file name = " + uploadFileName);

            try {
                s3Uploader.upload(multipartFile, uploadPath+ uploadFileName);
                location.setPicture(uploadFileName);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        int result = guideService.locationRegister(location);
        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/location")
    @ApiOperation(value = "추천 장소 삭제", notes = "추천 장소를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<?> locationDelete(@RequestParam Map<String, String> map) {
        int guideId = Integer.parseInt(map.get("guideId"));
        int recommendId = Integer.parseInt(map.get("recommendId"));

        //파일이 존재한다면 기존 경로에서 파일 삭제
        String existFile = guideService.findExistFile(recommendId);
        if (existFile != null) {
            String existPath = new String(rootPath + "/" + "location" + "/" + existFile);
            File file = new File(existPath);
            log.info("exist file path = " + file);

            if (file.exists()) {
                log.info("delete file");
                file.delete();
            }
        }

        guideService.locationDelete(guideId, recommendId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping(name = "/location", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "추천 장소 수정", notes = "추천 장소를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<?> locationUpdate(@RequestPart LocationPostRequest location, @RequestPart(name="uploadFile", required = false) MultipartFile multipartFile) {

        //파일이 존재한다면 기존 경로에서 파일 삭제
//        String existFile = guideService.findExistFile(location.getRecommendId());
//        if (existFile != null) {
//            String existPath = new String(rootPath + "/" + "loc" + "/" + existFile);
//            File file = new File(existPath);
//            log.info("exist file path = " + file);
//
//            if (file.exists()) {
//                log.info("delete file");
//                file.delete();
//            }
//        }

        if (!multipartFile.isEmpty()) {
            String uploadPath = rootPath + "/" + "location" + "/" + "picture" + "/";

            String fileName = multipartFile.getOriginalFilename();//원본 파일명
            String uploadFileName = UUID.randomUUID().toString() + "_" + fileName;
            log.info("file name = " + uploadFileName);

            try {
                s3Uploader.upload(multipartFile, uploadPath+ uploadFileName);
                location.setPicture(uploadFileName);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        int result = guideService.locationUpdate(location);
        if (result == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    // 추천 장소 조회
    @GetMapping("/location/{guideId}")
    @ApiOperation(value = "추천 장소 조회", notes = "추천 장소를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음")
    })
    public ResponseEntity<?> locationSearch(@PathVariable @ApiParam(value = "가이드의 유저 아이디(String)", required = true) String guideId) {
        List<LocationResponse> list = guideService.locationSearch(guideId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /////////////////////여행 테마 기능///////////////////////////

    @PutMapping("/thema/{guideId}")
    @ApiOperation(value = "여행 테마 등록", notes = "여행 테마를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류"),
            @ApiResponse(code = 204, message = "사용자 없음"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")
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
            @ApiResponse(code = 204, message = "사용자 없음"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<?> dayRegister(@RequestBody DayOffPostRequest dayOff) {
        LocalDate day = dayOff.getDay();
        String userId = dayOff.getUserId();

        int result = guideService.consultDateRegister(userId, day);
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
    public ResponseEntity<?> dayDelete(@RequestBody @ApiParam(value = "map의 key는 userId와 dayId") Map<String, String> map) {
        //log.info("userId = " + map.get("userId") + ", dayId = " + map.get("dayId"));

        String userId = map.get("userId");
        int dayId = Integer.parseInt(map.get("dayId"));

        int result = guideService.consultDateDelete(userId, dayId);
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
