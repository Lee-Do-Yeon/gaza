package com.idle.gaza.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
public class Consulting {

    @Id
    @Column(name="consulting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer consultingId;
    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservationId;
    @Column(name="start_time")
    private Timestamp startTime;
    @Column(name="end_time")
    private Timestamp endTime;
    private String url;
    @Column(name="is_activate", columnDefinition = "TINYINT", length=1)
    private Integer isActivate;


}
