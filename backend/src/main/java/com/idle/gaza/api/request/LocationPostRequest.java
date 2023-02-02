package com.idle.gaza.api.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("LocationPostRequest")
public class LocationPostRequest {


    private Integer recommendId;

    private Integer guideId;

    private String name;

    private String address;

    private String categoryCode;

    private String picture;

    private String latitude;

    private String longitude;


}
