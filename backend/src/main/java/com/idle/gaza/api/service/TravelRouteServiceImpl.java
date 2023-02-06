package com.idle.gaza.api.service;

import com.idle.gaza.api.request.TravelRouteRequest;
import com.idle.gaza.api.response.ReviewResponse;
import com.idle.gaza.api.response.TravelRouteResponse;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.entity.Review;
import com.idle.gaza.db.entity.TravelRoute;
import com.idle.gaza.db.repository.ReservationRepository;
import com.idle.gaza.db.repository.TravelRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TravelRouteServiceImpl implements TravelRouteService{

    @Autowired
    TravelRouteRepository travelRouteRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    @Transactional
    public Integer saveRoute(TravelRouteRequest routeInfo) throws Exception {
        // 예약 조회
        int reservationId = routeInfo.getReservationId();
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new NoSuchElementException("Reservation not found"));

        // 루트 생성
        TravelRoute route = new TravelRoute(
                reservation,
                routeInfo.getName(),
                routeInfo.getAddress(),
                routeInfo.getOrder(),
                routeInfo.getLatitude(),
                routeInfo.getLongitude());

        // 루트 저장
        travelRouteRepository.save(route);

        return route.getTravelRouteId();
    }

    @Override
    public List<TravelRouteResponse> getRoutes(Integer reservationId) {
        List<TravelRoute> routes = travelRouteRepository.findByRerservationId_ReservationId(reservationId);
        List<TravelRouteResponse> routeRes = new ArrayList<>(routes.size());
        for(int i=0; i<routes.size(); i++){
            TravelRoute route = routes.get(i);
            TravelRouteResponse res = new TravelRouteResponse(
                    route.getName(),
                    route.getAddress(),
                    route.getOrderNo(),
                    route.getLatitude(),
                    route.getLongitude()
            );
            routeRes.add(res);
        }
        return routeRes;
    }
}
