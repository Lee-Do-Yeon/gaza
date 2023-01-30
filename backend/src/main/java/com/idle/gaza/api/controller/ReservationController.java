package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.api.service.ReservationService;
import com.idle.gaza.common.model.response.BaseResponseBody;
import com.idle.gaza.db.entity.Reservation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 예약 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "예약 API", tags = {"Reservation"})
@RestController
@RequestMapping("message\":\"OTHER TOKEN ERROR\"")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @PostMapping
    @ApiOperation(value = "상담 예약", notes = "특정 가이드에 대해 상담을 예약한다.")
    public ResponseEntity<? extends BaseResponseBody> makeReservation(@RequestBody @ApiParam(value="예약 정보", required = true) ReservationCreatePostRequest reservationInfo){
        //임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
        Reservation reservation = reservationService.createReservation(reservationInfo);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }
}
