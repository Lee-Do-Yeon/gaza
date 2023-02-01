package com.idle.gaza.api.controller;

import com.idle.gaza.api.request.ReservationCreatePostRequest;
import com.idle.gaza.api.service.ReservationService;
import com.idle.gaza.common.model.response.BaseResponseBody;
import com.idle.gaza.db.entity.Reservation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * 예약 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "예약 API", tags = {"Reservation"})
@RestController
@RequestMapping("/books")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @PostMapping
    @ApiOperation(value = "상담 예약", notes = "특정 가이드에 대해 상담을 예약한다.")
    public ResponseEntity<? extends BaseResponseBody> makeReservation(@RequestBody @ApiParam(value="예약 정보", required = true) ReservationCreatePostRequest reservationInfo){
        reservationService.createReservation(reservationInfo);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "예약 내역 리스트 조회(회원)", notes = "회원은 본인의 상담 내역 리스트를 조회 가능하다.")
    public ResponseEntity<?> getReservationListByUser(@PathVariable @ApiParam(value="예약 정보", required = true) int userId){
        List<Reservation> reservationList = reservationService.getReservationListByUser(userId);
        return new ResponseEntity<List<?>>(reservationList, HttpStatus.OK);
    }
    @GetMapping("/guide/{guideId}")
    @ApiOperation(value = "예약 내역 리스트 조회(가이드)", notes = "가이드는 본인의 상담 내역 리스트를 조회 가능하다.")
    public ResponseEntity<?> getReservationListByGuide(@PathVariable @ApiParam(value="예약 정보", required = true) int guideId){
        List<Reservation> reservationList = reservationService.getReservationListByGuide(guideId);
        return new ResponseEntity<List<?>>(reservationList, HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    @ApiOperation(value = "예약 취소", notes = "회원은 예약을 취소할 수 있다.")
    public ResponseEntity<? extends BaseResponseBody> cancelReservation(@PathVariable @ApiParam(value="예약 ID", required = true) int reservationId){
        reservationService.cancelReservation(reservationId);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/guide/time")
    @ApiOperation(value = "불가능한 예약 시간 조회", notes = "회원은 불가능한 시간대를 확인 할 수 있다")
    public ResponseEntity<?> getImpossibleTime(@RequestParam("guideId") @ApiParam(value = "가이드 PK", required = true) int guideId,
                                               @RequestParam("selectedTime") @ApiParam(value = "선택한 날짜", required = true) Timestamp selectedTime){
        List<Timestamp> timeList = reservationService.getImpossibleTime(guideId, selectedTime);
        return new ResponseEntity<List<?>>(timeList, HttpStatus.OK);
    }
}
