package com.idle.gaza.api.service;

import com.idle.gaza.api.request.ConsultingCreateRequest;
import com.idle.gaza.db.entity.Consulting;
import com.idle.gaza.db.entity.Reservation;
import com.idle.gaza.db.repository.ConsultingRepository;
import com.idle.gaza.db.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class ConsultingServiceImpl implements ConsultingService {

    private final ConsultingRepository consultingRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ConsultingServiceImpl(ConsultingRepository consultingRepository, ReservationRepository reservationRepository) {
        this.consultingRepository = consultingRepository;
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Integer makeConsulting(String url, final ConsultingCreateRequest req) {
        Reservation reservation = reservationRepository.findById(req.getReservationId()).orElse(null);
        if(reservation==null){
            throw new EntityNotFoundException();
        }
        Consulting consulting = Consulting.builder()
                .reservationId(reservation)
                .url(url)
                .startTime(LocalDateTime.now())
                .isActivate(0) // 헷갈리네. 이걸 언제 만들지. 상담 시간에 맞춰서? 아니면 그 전에?
                .build();
        consultingRepository.save(consulting);
        return consultingRepository.findByReservationId(req.getReservationId()).orElse(null).getConsultingId();
    }

    @Transactional
    public Consulting findConsulting(Integer consultingId) {
        Consulting consulting = consultingRepository.findById(consultingId).orElse(null);

        if (consulting == null) { // 컨설팅 룸 찾지 못함.
            throw new EntityNotFoundException();
        }

        if (consulting.getIsActivate() == 0) { // 이미 종료된 컨설팅
            throw new EntityNotFoundException();
        }

        return consultingRepository.findById(consultingId).orElse(null);
    }

    @Transactional
    public void endConsulting(Integer consultingId) {
        Consulting updateConsulting = consultingRepository.findById(consultingId).orElse(null);

        if (updateConsulting == null) {
            throw new EntityNotFoundException();
        }

        updateConsulting.setIsActivate(0);
        consultingRepository.save(updateConsulting);
    }

//    @Transactional(readOnly = true)
//    public RoomRes getRoomRes(String roomId, Integer gameType) {
//        RoomRes roomRes = new RoomRes();
//        User user = userRepository.findOneWithRolesByEmail(SecurityUtil.getCurrentEmail().orElse("")).orElse(null);
//
//        roomRes.setRoomId(roomId);
//        roomRes.setGameType(gameType);
//        roomRes.setNickname(user.getNickname());
//
//        return roomRes;
//    }
}
