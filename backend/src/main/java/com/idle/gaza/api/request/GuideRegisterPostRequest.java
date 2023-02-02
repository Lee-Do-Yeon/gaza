package com.idle.gaza.api.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class GuideRegisterPostRequest {

    private int guideId;//guide pk

    private String id;//user pk

    private String onlineIntroduction;

    private String introduction;

    private String picture;

    private String country;

    private String city;

    private LocalTime closeTimeStart;

    private LocalTime closeTimeEnd;

    private Integer price;

    private Integer license;

}
