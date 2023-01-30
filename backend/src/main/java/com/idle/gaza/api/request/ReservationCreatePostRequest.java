package com.idle.gaza.api.request;

import com.idle.gaza.db.entity.Guide;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class ReservationCreatePostRequest {
    private int userId;
    private int guideId;
    private Timestamp consultingDate;
    private Timestamp reservationDate;
    private Timestamp travelStartDate;
    private Timestamp travelEndDate;
    private int numberOfPeople;
    private int withChildren;
    private int withElderly;
    private int withDisabled;
    private String note;
}
