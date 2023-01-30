package com.idle.gaza.api.request;

import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class ReservationCreatePostRequest {
    private UserDto userId;
    private Guide guideId;
    private Timestamp consultingDate;
    private Timestamp reservationDate;
    private Timestamp travleStartDate;
    private Timestamp travleEndDate;
    private int numberOfPeople;
    private int withChildren;
    private int withElderly;
    private int withDisabled;
    private String note;
}
