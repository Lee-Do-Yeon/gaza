package com.idle.gaza.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel("ReviewCreatePostRequest")
public class ReviewCreatePostRequest {
    @ApiModelProperty(name="예약 ID", example="5")
    private int reservationId;

    @ApiModelProperty(name="리뷰 내용", example="정말 좋아요")
    private String content;

    @ApiModelProperty(name="별점(1~5)", example="5")
    private int score;
}
