package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ConsultingCreateRequest;
import com.idle.gaza.db.entity.Consulting;

public interface ConsultingService {
    Integer makeConsulting(String url, ConsultingCreateRequest makeRoomReq);
    Consulting findConsulting(Integer consultingId);
    void endConsulting(Integer consultingId);

}
