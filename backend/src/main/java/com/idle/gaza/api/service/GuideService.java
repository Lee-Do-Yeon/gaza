package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.GuideRecommendLocation;

public interface GuideService {

    //가이드 추천 장소 기능
    void locationRegister(GuideRecommendLocation locations);
    void locationDelete(Long recommendId);
    void locationUpdate(GuideRecommendLocation locations);


}
