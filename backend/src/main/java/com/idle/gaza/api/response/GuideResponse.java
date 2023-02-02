package com.idle.gaza.api.response;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalTime;

@ApiModel("GuideResponse")
@Getter
@Setter
@NoArgsConstructor
public class GuideResponse {

    private int guideId;

    private int userId;

    private String name;


    private String picture;

    private String country;

    private String city;

    private LocalTime closeTimeStart;

    private LocalTime closeTimeEnd;

    private Integer price;


    @Builder
    public GuideResponse(int guideId, int userId, String name, String picture, String country, String city, LocalTime closeTimeStart, LocalTime closeTimeEnd, Integer price) {
        this.guideId = guideId;
        this.userId = userId;
        this.name = name;
        this.picture = picture;
        this.country = country;
        this.city = city;
        this.closeTimeStart = closeTimeStart;
        this.closeTimeEnd = closeTimeEnd;
        this.price = price;
    }
}
