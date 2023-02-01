package com.idle.gaza.api.service;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.request.LocationPostRequest;
import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.GuideRecommendLocation;
import com.idle.gaza.db.entity.User;
import com.idle.gaza.db.repository.GuideRecommendRepository;
import com.idle.gaza.db.repository.GuideRepository;
import com.idle.gaza.db.repository.UserRepository;
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

    @Autowired
    GuideRecommendRepository guideRecommendRepository;

    @Autowired
    GuideRepository guideRepository;

    @Autowired
    UserRepository userRepository;

    ///////////////////////가이드 조회 기능/////////////////////////

    @Override
    public List<Guide> guideSearch() {
        return guideRepository.findBy();
    }

    @Override
    public List<Guide> famousGuideSearch() {
        return null;
    }

    @Override
    public Guide guideDetailSearch(int userId) {
        //먼저 회원이 존재하는지 확인
        Optional<User> user = userRepository.findByUserId(userId);
        if(!user.isPresent()) return null;

        //해당 회원이 가이드인지 확인 후 가이드 정보 리턴
        int id = user.get().getUserId();
        Optional<Guide> guide = guideRepository.findGuideByUser(id);

        if(!guide.isPresent()) System.out.println("guide is not exist");
        else System.out.println("guide is exist");

        return guide.orElse(null);

    }

    ////////////////////////추천 장소 기능//////////////////////
    @Override
    public void locationRegister(LocationPostRequest locations) {
        //해당 가이드가 존재하는지 확인함
        Optional<Guide> guide = guideRepository.findGuideByGuideId(locations.getGuideId());

        if(guide.isPresent()) {
            GuideRecommendLocation loc = GuideRecommendLocation
                .builder()
                .guide(guide.get())
                .address(locations.getAddress())
                .latitude(locations.getLatitude())
                .longitude(locations.getLongitude())
                .categoryCode(locations.getCategoryCode())
                .picture(locations.getPicture())
                .build();
            guideRecommendRepository.save(loc);
        }

    }

    @Override
    public void locationDelete(int guideId, int recommendId) {
        //해당 가이드가 존재하는 지 확인함
        Optional<Guide> existGuide = guideRepository.findGuideByGuideId(guideId);

        //해당 가이드의 추천 장소가 있는지 확인함
        if(existGuide.isPresent()){
            Optional<GuideRecommendLocation> location = guideRecommendRepository.findGuideRecommendLocationByRecommendId(recommendId);
            if(location.isPresent()){
                //추천 장소를 삭제한다.
                guideRecommendRepository.deleteGuideRecommendLocationByRecommendId(recommendId);
            }
        }
    }

    @Override
    public int locationUpdate(LocationPostRequest locations) {
        //해당 가이드가 존재하는지 확인함
        Optional<Guide> guide = guideRepository.findGuideByGuideId(locations.getGuideId());

        if(!guide.isPresent()) return 0;

        //해당 가이드 추천장소가 존재하는 경우에만 수행
        Optional<GuideRecommendLocation> existLocation = guideRecommendRepository.findGuideRecommendLocationByRecommendId(locations.getRecommendId());

        if(!existLocation.isPresent()) return 0;

        GuideRecommendLocation updateLocation = existLocation.get();
        updateLocation.setGuide(guide.get());
        updateLocation.setAddress(locations.getAddress());
        updateLocation.setLongitude(locations.getLongitude());
        updateLocation.setLatitude(locations.getLatitude());
        updateLocation.setName(locations.getName());
        updateLocation.setPicture(locations.getPicture());
        updateLocation.setCategoryCode(locations.getCategoryCode());

        guideRecommendRepository.save(updateLocation);

        return 1;//성공 시
    }


    //////////////////가이드 등록////////////////////////////

    @Override
    public void guideRegister(GuideRegisterPostRequest guide) {

    }

}
