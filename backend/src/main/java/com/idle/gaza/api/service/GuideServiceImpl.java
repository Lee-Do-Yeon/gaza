package com.idle.gaza.api.service;

import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.GuideRecommendLocation;
import com.idle.gaza.db.repository.GuideRecommendRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* Guide 관련 비스니스 로직 처리를 위한 서비스 클래스
* */
@Service("guideService")
@Log4j2
public class GuideServiceImpl implements GuideService {

    private GuideRecommendRepository repository;

    @Autowired
    public GuideServiceImpl(GuideRecommendRepository repository) {
        this.repository = repository;
    }

    ///////////////////////가이드 조회 기능/////////////////////////

    @Override
    public List<Guide> guideSearch() {
        return null;
    }

    @Override
    public List<Guide> famousGuideSearch() {
        return null;
    }

    ////////////////////////추천 장소 기능//////////////////////
    @Override
    public void locationRegister(GuideRecommendLocation locations) {
        GuideRecommendLocation loc = GuideRecommendLocation
                .builder()
                .guide(locations.getGuide())
                .address(locations.getAddress())
                .latitude(locations.getLatitude())
                .longitude(locations.getLongitude())
                .categoryCode(locations.getCategoryCode())
                .picture(locations.getPicture())
                .build();
        repository.save(loc);
    }

    @Override
    public void locationDelete(int guideId, Long recommendId) {
        //해당 가이드가 존재하는 지 확인함

    }

    @Override
    public int locationUpdate(GuideRecommendLocation locations) {
        //해당 가이드가 존재하는 경우에만 수행
        Optional<Guide> existGuide = repository.findByGuideId(locations.getGuide().getGuideId());

        if(!existGuide.isPresent()) return 0;



        return 1;//성공 시
    }


}
