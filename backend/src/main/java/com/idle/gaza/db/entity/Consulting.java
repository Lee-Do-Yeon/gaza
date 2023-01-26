package com.idle.gaza.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Consulting {

    @Id
    @Column(name="consulting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Reservation rid;
    @Column(name="start_time")
    private Date startTime;
    @Column(name="end_time")
    private Date endTime;
    private String url;
    @Column(name="is_activate", columnDefinition = "TINYINT", length=1)
    private int isActivate;


}
