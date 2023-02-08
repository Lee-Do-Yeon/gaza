package com.idle.gaza.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Consulting {

    @Id
    @Column(name="consulting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consultingId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="reservation_id")
    private Reservation reservationId;
    @Column(name="start_time")
    private LocalDateTime startTime;
    @Column(name="end_time")
    private LocalDateTime endTime;
    private String url;
    @Column(name="is_activate", columnDefinition = "TINYINT", length=1)
    private Integer isActivate;

    @Builder
    public Consulting(Reservation reservationId, LocalDateTime startTime, String url, Integer isActivate) {
        this.reservationId = reservationId;
        this.startTime = startTime;
        this.url = url;
        this.isActivate = isActivate;
    }
}
