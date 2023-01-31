package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.GuideRecommendLocation;

import java.util.List;

public interface GuideService {

    //가이드 조회 기능
    List<Guide> guideSearch();
    List<Guide> famousGuideSearch();
    Guide guideDetailSearch();


    //가이드 추천 장소 기능
    void locationRegister(GuideRecommendLocation locations);
    void locationDelete(int guideId, Long recommendId);
    int locationUpdate(GuideRecommendLocation locations);



}
