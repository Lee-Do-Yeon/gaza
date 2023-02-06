package com.idle.gaza.api.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("TravelRouteResponse")
@AllArgsConstructor
public class TravelRouteResponse {
    private String name;
    private String address;
    private int order;
    private String latitude;
    private String longitude;
}
