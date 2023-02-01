package com.idle.gaza.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewCreatePostRequest {
    private int reservationId;
    private String content;
    private int score;
}
