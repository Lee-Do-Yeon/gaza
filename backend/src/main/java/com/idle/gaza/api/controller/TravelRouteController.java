package com.idle.gaza.api.controller;

import com.idle.gaza.api.service.ReviewServiceImpl;
import com.idle.gaza.api.service.TravelRouteServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "여행일정 API", tags = {"Travel Route"})
@RestController
@RequestMapping("/routes")
public class TravelRouteController {

    @Autowired
    TravelRouteServiceImpl travelRouteService;
}
