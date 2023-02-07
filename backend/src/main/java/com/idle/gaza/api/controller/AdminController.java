package com.idle.gaza.api.controller;

import com.idle.gaza.common.codes.SuccessCode;
import com.idle.gaza.common.response.ApiResponse;
import com.idle.gaza.common.util.TokenUtil;
import com.idle.gaza.db.entity.GuideDocument;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Api(value = "관리자 API", tags = {"Admin"})
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    TokenUtil tokenUtil;

    /**
     * [API] 가이드 신청 승인
     *
     * @param accessToken String
     * @return ResponseEntity
     * <p>
     * 프론트에서 만료 시간을 가지고 있다면 자체적으로 확인 가능할듯(만료X면 그대로 사용, 만료됐으면 auth/reissue
     */
    @PutMapping("/guide/success")
    public ResponseEntity<ApiResponse<Object>> acceptGuide(@RequestHeader("Authorization") String accessToken) {

        String token = tokenUtil.getTokenFromHeader(accessToken);

        String id = tokenUtil.getUserIdFromToken(token);

        ApiResponse<Object> ar = ApiResponse.builder()
                .result(null)
                .resultCode(SuccessCode.UPDATE.getStatus())
                .resultMsg(SuccessCode.UPDATE.getMessage())
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }

    /**
     * [API] 가이드 신청 거절
     *
     * @param accessToken String
     * @return ResponseEntity
     * <p>
     * 프론트에서 만료 시간을 가지고 있다면 자체적으로 확인 가능할듯(만료X면 그대로 사용, 만료됐으면 auth/reissue
     */
    @PutMapping("/guide/success")
    public ResponseEntity<ApiResponse<Object>> rejectGuide(@RequestHeader("Authorization") String accessToken) {

        String token = tokenUtil.getTokenFromHeader(accessToken);

        String id = tokenUtil.getUserIdFromToken(token);

        ApiResponse<Object> ar = ApiResponse.builder()
                .result(null)
                .resultCode(SuccessCode.UPDATE.getStatus())
                .resultMsg(SuccessCode.UPDATE.getMessage())
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }
}
