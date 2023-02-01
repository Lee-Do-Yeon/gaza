package com.idle.gaza.db.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guide{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="guide_id")
    private Integer guideId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;


    @Column(name="oneline_introduction")
    private String onlineIntroduction;

    private String introduction;

    private String picture;

    private String country;

    private String city;

    @Column(name="close_time_start")
    private LocalTime closeTimeStart;

    @Column(name="close_time_end")
    private LocalTime closeTimeEnd;

    private Integer price;

    @Column(columnDefinition = "TINYINT", length=1)
    private Integer license;

    @OneToMany(mappedBy = "guide")
    private List<GuideRecommendLocation> guideLocationList = new ArrayList<>();

    @OneToMany(mappedBy = "guide")
    private List<DayOff> dayOffList = new ArrayList<>();

    public void addGuideLocation(GuideRecommendLocation guideLocationList){
        this.guideLocationList.add(guideLocationList);
    }

    public List<GuideRecommendLocation> getGuideLocationList() {
        return guideLocationList;
    }

    public List<DayOff> getDayOffList() {
        return dayOffList;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public String getOnlineIntroduction() {
        return onlineIntroduction;
    }

    public void setOnlineIntroduction(String onlineIntroduction) {
        this.onlineIntroduction = onlineIntroduction;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalTime getCloseTimeStart() {
        return closeTimeStart;
    }

    public void setCloseTimeStart(LocalTime closeTimeStart) {
        this.closeTimeStart = closeTimeStart;
    }

    public LocalTime getCloseTimeEnd() {
        return closeTimeEnd;
    }

    public void setCloseTimeEnd(LocalTime closeTimeEnd) {
        this.closeTimeEnd = closeTimeEnd;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }



}
