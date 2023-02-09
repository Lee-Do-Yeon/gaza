package com.idle.gaza.api.controller;

import com.idle.gaza.api.dto.TokenDto;
import com.idle.gaza.api.service.UserService;
import com.idle.gaza.common.codes.SuccessCode;
import com.idle.gaza.common.response.ApiResponse;
import com.idle.gaza.common.util.TokenUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "관리자 API", tags = {"Admin"})
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * [API] 가이드 신청 승인
     *
     * @param id String
     * @return ResponseEntity
     *
     *
     */
    @PutMapping("/guide/success")
    public ResponseEntity<ApiResponse<Object>> acceptGuide(@RequestParam String id) {
        userService.changeState(id, "US1");

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
     * @param id String
     * @return ResponseEntity
     *
     *
     */
    @PutMapping("/guide/failure")
    public ResponseEntity<ApiResponse<Object>> rejectGuide(@RequestParam String id) {
        userService.changeState(id, "US2");

        ApiResponse<Object> ar = ApiResponse.builder()
                .result(null)
                .resultCode(SuccessCode.UPDATE.getStatus())
                .resultMsg(SuccessCode.UPDATE.getMessage())
                .build();
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }
}