package com.idle.gaza.api.service;

import com.idle.gaza.api.request.TravelRouteRequest;
import com.idle.gaza.api.response.TravelRouteResponse;

import java.util.List;

public interface TravelRouteService {
    Integer saveRoute(TravelRouteRequest routeInfo) throws Exception;
    List<TravelRouteResponse> getRoutes(Integer reservationId);
}
