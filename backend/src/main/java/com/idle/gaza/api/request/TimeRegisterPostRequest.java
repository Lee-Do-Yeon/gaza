package com.idle.gaza.api.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

/*
* 가이드 상담 시간대 설정을 받는 클래스
* */
@Getter
@Setter
@ApiModel("TimeRegisterPostRequest")
public class TimeRegisterPostRequest {

    private String userId;

    private LocalTime startTime;
    private LocalTime endTime;

}
