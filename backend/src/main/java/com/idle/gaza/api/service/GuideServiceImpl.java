package com.idle.gaza.api.service;

import com.idle.gaza.api.request.GuideRegisterPostRequest;
import com.idle.gaza.api.request.LocationPostRequest;
import com.idle.gaza.api.response.GuideResponse;
import com.idle.gaza.api.response.LocationResponse;
import com.idle.gaza.db.entity.*;
import com.idle.gaza.db.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    @Autowired
    GuideThemaRepository guideThemaRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReviewRepository reviewRepository;

    ///////////////////////가이드 조회 기능/////////////////////////


    @Override
    public List<Guide> guideSearch() {
        return guideRepository.findBy();
    }

    @Override
    public List<GuideResponse> famousGuideSearch() {
        //예약 많은 순으로 정렬
        List<Guide> orderByGuide = guideRepository.findOrderByMaxReservation();

        List<GuideResponse> guideResponseList = new ArrayList<>();
        for (Guide guide : orderByGuide) {

            GuideResponse guideResponse = GuideResponse.builder()
                    .guideId(guide.getGuideId())
                    .name(guide.getUser().getName())
                    .city(guide.getCity())
                    .closeTimeEnd(guide.getCloseTimeEnd())
                    .closeTimeStart(guide.getCloseTimeStart())
                    .country(guide.getCountry())
                    .price(guide.getPrice())
                    .picture(guide.getPicture())
                    .build();
            guideResponseList.add(guideResponse);


        }

        return guideResponseList;
    }

    @Override
    public Guide guideDetailSearch(int guideId) {

        //가이드 정보 리턴
        Optional<Guide> guide = guideRepository.findGuideByGuideId(guideId);
        return guide.orElse(null);
    }


    ////////////////////////추천 장소 기능//////////////////////
    @Override
    public int locationRegister(LocationPostRequest locations) {
        //해당 가이드가 존재하는지 확인함
        Optional<Guide> guide = guideRepository.findGuideByGuideId(locations.getGuideId());

        if (!guide.isPresent()) return 0;

        GuideRecommendLocation loc = GuideRecommendLocation
                .builder()
                .guide(guide.get())
                .address(locations.getAddress())
                .latitude(locations.getLatitude())
                .longitude(locations.getLongitude())
                .categoryCode(locations.getCategoryCode())
                .picture(locations.getPicture())
                .name(locations.getName())
                .build();
        guideRecommendRepository.save(loc);

        return 1;
    }

    @Override
    public int locationDelete(int guideId, int recommendId) {
        Optional<Guide> existGuide = guideRepository.findGuideByGuideId(guideId);

        if (!existGuide.isPresent()) return 0;

        Optional<GuideRecommendLocation> location = guideRecommendRepository.findByRecommendId(recommendId);

        if (!location.isPresent()) return 0;

        //추천 장소를 삭제한다.
        guideRecommendRepository.deleteByRecommendId(recommendId);
        return 1;
    }

    @Override
    public int locationUpdate(LocationPostRequest locations) {
        //해당 가이드가 존재하는지 확인함
        Optional<Guide> guide = guideRepository.findGuideByGuideId(locations.getGuideId());
        if (!guide.isPresent()) return 0;

        //해당 가이드 추천장소가 존재하는 경우에만 수행
        Optional<GuideRecommendLocation> existLocation = guideRecommendRepository.findByRecommendId(locations.getRecommendId());

        if (!existLocation.isPresent()) return 0;

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

    @Override
    public List<LocationResponse> locationSearch(String guideId) {
        List<GuideRecommendLocation> locations = guideRecommendRepository.findByGuide_UserId_Id(guideId);
        List<LocationResponse> locationRes = new ArrayList<>(locations.size());
        for(int i=0; i<locations.size(); i++){
            GuideRecommendLocation location = locations.get(i);
            LocationResponse res = new LocationResponse(
                    location.getName(),
                    location.getAddress(),
                    location.getCategoryCode(),
                    location.getLatitude(),
                    location.getLongitude()
            );
            locationRes.add(res);
        }
        return locationRes;
    }

    @Override
    public String findExistFile(int recommendId) {
        Optional<GuideRecommendLocation> loc = guideRecommendRepository.findByRecommendId(recommendId);
        String file = loc.get().getPicture();

        return file;
    }

    //////////////////가이드 등록////////////////////////////

    @Override
    public int guideRegister(GuideRegisterPostRequest guide) {
        //해당 회원이 존재하는지 확인함
        Optional<User> checkId = userRepository.findById(guide.getId());
        if (!checkId.isPresent()) return 0;

        Optional<User> user = userRepository.findByUserId(checkId.get().getUserId());
        if (!user.isPresent()) return 0;

        //가이드가 이미 존재하는 경우
        Optional<Guide> existGuide = guideRepository.findGuideByUser(user.get().getUserId());
        if (existGuide.isPresent()) return 0;


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
        return 1;
    }


    ////////////////상담 날짜 관리 기능/////////////////////

    @Override
    public int consultDateRegister(String userId, LocalDate dayoff) {
        Optional<User> checkUser = userRepository.findById(userId);//로그인 아이디로 사용자 얻기
        if (!checkUser.isPresent()) return 0;
        System.out.println("user id" + checkUser.get().getUserId());

        int id = checkUser.get().getUserId();
        Optional<Guide> checkGuide = guideRepository.findGuideByUser(id);//위에서 얻은 사용자로 가이드인지 확인함
        if (!checkGuide.isPresent()) return 0;

        //상담 불가능한 날짜를 추가함
        DayOff dayOff = DayOff.builder().dayOffDate(dayoff).guide(checkGuide.get()).build();
        dayOffRepository.save(dayOff);

        return 1;
    }

    //상담 날짜 삭제
    @Override
    public int consultDateDelete(String userId, int dayOffId) {

        //해당 가이드의 상담 날짜가 존재하는지 확인함
        Optional<DayOff> day = dayOffRepository.findDayOffByDayOffId(dayOffId);
        if (!day.isPresent()) return 0;

        dayOffRepository.deleteById(dayOffId);

        return 1;
    }


    ////////////////////상담 시간대 관리 기능/////////////////////////////

    @Override
    public int consultTimeRegister(LocalTime startTime, LocalTime endTime, String userId) {
        //해당 가이드가 존재하는지 확인한다.
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) return 0;

        Optional<Guide> existGuide = guideRepository.findGuideByUser(user.get().getUserId());
        if (!existGuide.isPresent()) return 0;

        Guide guideInfo = existGuide.get();

        Guide guide = Guide.builder()
                .guideId(guideInfo.getGuideId())
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
                .build();

        guideRepository.save(guide);

        return 1;
    }

    ////////////////////여행 테마 관리///////////////////////


    @Override
    public int tourThemaRegister(int guideId, String themaCode) {
        //가이드 정보 반환
        Optional<Guide> existGuide = guideRepository.findById(guideId);
        if (!existGuide.isPresent()) return 0;

        GuideThema thema = GuideThema.builder().themaCode(themaCode).guide(existGuide.get()).build();

        guideThemaRepository.save(thema);

        return 1;
    }

    @Override
    public int tourThemaDelete(int guideId, int themaId) {
        //가이드 정보 반환
        Optional<Guide> existGuide = guideRepository.findById(guideId);
        if (!existGuide.isPresent()) return 0;

        //테마를 삭제함
        guideThemaRepository.deleteByThemaId(themaId);

        return 1;
    }


}
