package com.idle.gaza.api.request;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("MyPageRequest")
public class MyPageRequest {

    private String onlineIntroduction;

    private String introduction;

    private int price;

    private String country;

    private String city;

    private String picture;

}
