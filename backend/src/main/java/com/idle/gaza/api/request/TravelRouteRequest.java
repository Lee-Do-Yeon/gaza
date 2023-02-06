package com.idle.gaza.api.request;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel("TravleRouteRequest")
public class TravelRouteRequest {
    private Integer TravelRouteId;
    private Integer reservationId;
    private String name;
    private String address;
    private int order;
    private String latitude;
    private String longitude;
}
