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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guide{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="guide_id")
    private Integer guideId;

//    @OneToOne
//    @JoinColumn(name="user_id")
//    User user;

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

    public void addguideLocation(GuideRecommendLocation guideLocationList){
        this.guideLocationList.add(guideLocationList);
    }

}
