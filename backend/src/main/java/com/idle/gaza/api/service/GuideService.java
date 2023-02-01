package com.idle.gaza.api.service;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.request.LocationPostRequest;
import com.idle.gaza.db.entity.Guide;

import java.util.List;

public interface GuideService {

    //가이드 조회 기능
    List<Guide> guideSearch();
    List<Guide> famousGuideSearch();
    Guide guideDetailSearch(int userId);


    //가이드 추천 장소 기능
    void locationRegister(LocationPostRequest locations);
    void locationDelete(int guideId, int recommendId);
    int locationUpdate(LocationPostRequest locations);

    //상담 날짜 관리 기능

    //상담 시간대 관리 기능

    //가이드 사용 언어 관리 기능

    //여행 테마 관리 기능


    //가이드 등록
    void guideRegister(GuideRegisterPostRequest guide);

}
