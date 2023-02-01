package com.idle.gaza.api.service;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.request.LocationPostRequest;
import com.idle.gaza.db.entity.DayOff;
import com.idle.gaza.db.entity.Guide;
import com.idle.gaza.db.entity.GuideRecommendLocation;
import com.idle.gaza.db.entity.User;
import com.idle.gaza.db.repository.DayOffRepository;
import com.idle.gaza.db.repository.GuideRecommendRepository;
import com.idle.gaza.db.repository.GuideRepository;
import com.idle.gaza.db.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
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

    @Autowired
    DayOffRepository dayOffRepository;

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
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) return null;

        //해당 회원이 가이드인지 확인 후 가이드 정보 리턴
        Optional<Guide> guide = guideRepository.findGuideByUser(userId);

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
        //해당 회원이 존재하는지 확인함
        Optional<User> user = userRepository.findByUserId(guide.getUserId());
        if(user.isPresent()){
            Guide newGuide = Guide.builder()
                    .user(user.get())
                    .picture(guide.getPicture())
                    .price(guide.getPrice())
                    .license(guide.getLicense())
                    .onlineIntroduction(guide.getOnlineIntroduction())
                    .introduction(guide.getIntroduction())
                    .country(guide.getCountry())
                    .city(guide.getCity())
                    .closeTimeStart(guide.getCloseTimeStart())
                    .closeTimeEnd(guide.getCloseTimeEnd())
                    .build();

            guideRepository.save(newGuide);
        }
    }



    ////////////////상담 날짜 관리 기능/////////////////////

    @Override
    public void consultDateRegister(DayOff dayoff) {
        //해당 가이드가 존재하는지 확인한다.
        int id = dayoff.getGuide().getGuideId();
        Optional<Guide> existGuide = guideRepository.findGuideByGuideId(id);

        if(existGuide.isPresent()){
            //상담 불가능한 날짜를 추가함


            //guideRepository.save(guide);
        }
    }

    //상담 날짜 삭제
    @Override
    public void consultDateDelete(DayOff dayOff) {
        //해당 가이드의 상담 날짜가 존재하는지 확인함
        Optional<DayOff> day = dayOffRepository.findDayOffByDayOffId(dayOff.getDayOffId());

    }



    ////////////////////상담 시간대 관리 기능/////////////////////////////

    @Override
    public void consultTimeRegister(LocalTime startTime, LocalTime endTime, int guideId) {
        //해당 가이드가 존재하는지 확인한다.
        Optional<Guide> existGuide = guideRepository.findGuideByGuideId(guideId);

        //상담 시간대를 등록한다.
        if(existGuide.isPresent()){
            Guide guideInfo = existGuide.get();
            Guide guide = Guide.builder()
                    .guideId(guideId)
                    .guideLocationList(guideInfo.getGuideLocationList())
                    .city(guideInfo.getCity())
                    .closeTimeEnd(endTime)
                    .closeTimeStart(startTime)
                    .dayOffList(guideInfo.getDayOffList())
                    .introduction(guideInfo.getIntroduction())
                    .license(guideInfo.getLicense())
                    .onlineIntroduction(guideInfo.getOnlineIntroduction())
                    .price(guideInfo.getPrice())
                    .picture(guideInfo.getPicture())
                    .country(guideInfo.getCountry())
                    .user(guideInfo.getUser())
                    .build()
                    ;

            guideRepository.save(guide);
        }

    }




}
