package com.idle.gaza.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewCreatePostRequest {
    private int reservationId;
    private String content;
    private int score;
}
