package com.idle.gaza.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Guide guide;

    @Column(name="state_code")
    private String stateCode;

    @Column(name="consulting_date")
    private Date consultingDate;

    @Column(name="reservation_date")
    private Date reservationDate;

    @Column(name="travle_start_date")
    private Date travleStartDate;

    @Column(name="travle_end_date")
    private Date travleEndDate;

    @Column(name="number_of_people")
    private int numberOfPeople;

    @Column(name="with_children", columnDefinition = "TINYINT", length=1)
    private int withChildren;

    @Column(name="with_elderly", columnDefinition = "TINYINT", length=1)
    private int withElderly;

    @Column(name="with_disabled", columnDefinition = "TINYINT", length=1)
    private int withDisabled;

    private String note;
}
