package com.idle.gaza.api.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("LocationResponse")
@AllArgsConstructor
public class LocationResponse {
    private String name;
    private String address;
    private String categoryCode;
    private String latitude;
    private String longitude;
}
