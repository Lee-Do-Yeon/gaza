package com.idle.gaza.api.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ApiModel("DayOffPostRequest")
public class DayOffPostRequest {

    String userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate day;

}
