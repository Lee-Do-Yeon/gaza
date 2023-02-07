package com.idle.gaza.api.response;

import com.idle.gaza.db.entity.DayOff;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.entity.Review;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    private String onelineIntroduction;

    private String introduction;

    private List<String> language = new ArrayList<>();

    private List<String> thema = new ArrayList<>();

    private List<Reservation> reservationList = new ArrayList<>();

    private List<Review> reviewList = new ArrayList<>();

    private List<DayOff> dayOffList = new ArrayList<>();

    @Builder
    public GuideResponse(int guideId, int userId, String name, String picture, String country, String city, LocalTime closeTimeStart, LocalTime closeTimeEnd, Integer price, String onelineIntroduction, String introduction, List<String> language, List<String> thema, List<Reservation> reservationList, List<Review> reviewList, List<DayOff> dayOffList) {
        this.guideId = guideId;
        this.userId = userId;
        this.name = name;
        this.picture = picture;
        this.country = country;
        this.city = city;
        this.closeTimeStart = closeTimeStart;
        this.closeTimeEnd = closeTimeEnd;
        this.price = price;
        this.onelineIntroduction = onelineIntroduction;
        this.introduction = introduction;
        this.language = language;
        this.thema = thema;
        this.reservationList = reservationList;
        this.reviewList = reviewList;
        this.dayOffList = dayOffList;
    }

}
