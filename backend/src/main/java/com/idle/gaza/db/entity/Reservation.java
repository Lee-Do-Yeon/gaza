package com.idle.gaza.db.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {
    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserDto userId;

    @ManyToOne
    @JoinColumn(name="guide_id")
    private Guide guideId;

    @Column(name="state_code")
    private String stateCode;

    @Column(name="consulting_date")
    private Timestamp consultingDate;

    @Column(name="reservation_date")
    private Timestamp reservationDate;

    @Column(name="travle_start_date")
    private Timestamp travleStartDate;

    @Column(name="travle_end_date")
    private Timestamp travleEndDate;

    @Column(name="number_of_people")
    private int numberOfPeople;

    @Column(name="with_children", columnDefinition = "TINYINT", length=1)
    private int withChildren;

    @Column(name="with_elderly", columnDefinition = "TINYINT", length=1)
    private int withElderly;

    @Column(name="with_disabled", columnDefinition = "TINYINT", length=1)
    private int withDisabled;

    private String note;

    @Builder
    public Reservation(UserDto userId, Guide guideId, Timestamp consultingDate, Timestamp reservationDate, Timestamp travleStartDate, Timestamp travleEndDate, int numberOfPeople, int withChildren, int withElderly, int withDisabled, String note) {
        this.userId = userId;
        this.guideId = guideId;
        this.consultingDate = consultingDate;
        this.reservationDate = reservationDate;
        this.travleStartDate = travleStartDate;
        this.travleEndDate = travleEndDate;
        this.numberOfPeople = numberOfPeople;
        this.withChildren = withChildren;
        this.withElderly = withElderly;
        this.withDisabled = withDisabled;
        this.note = note;
    }
}
