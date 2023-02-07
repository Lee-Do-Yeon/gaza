package com.idle.gaza.api.service;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.request.LocationPostRequest;
import com.idle.gaza.api.response.GuideResponse;
import com.idle.gaza.api.response.LocationResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface GuideService {

    //가이드 조회 기능
    List<GuideResponse> guideSearch();
    List<GuideResponse> famousGuideSearch();
    GuideResponse guideDetailSearch(int guideId);
    List<GuideResponse> guideSearchBar(String searchName);

    //가이드 추천 장소 기능
    int locationRegister(LocationPostRequest locations);
    int locationDelete(int guideId, int recommendId);
    int locationUpdate(LocationPostRequest locations);
    List<LocationResponse> locationSearch(String guideId);

    String findExistFile(int recommendId);

    //상담 날짜 관리 기능
    int consultDateRegister(String userId, LocalDate dayoff);
    int consultDateDelete(String userId, int dayOffId);

    //상담 시간대 관리 기능
    int consultTimeRegister(LocalTime startTime, LocalTime endTime, String userId);

    //가이드 사용 언어 관리 기능

    //여행 테마 관리 기능
    int tourThemaRegister(int guideId, String themaCode);
    int tourThemaDelete(int guideId, int themaId);

    //가이드 등록
    int guideRegister(GuideRegisterPostRequest guide);

}
