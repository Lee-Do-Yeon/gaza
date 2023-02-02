package com.idle.gaza.db.entity;

import io.jsonwebtoken.lang.Assert;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name="guide_id")
    private Guide guideId;

    @Column(name="state_code")
    private String stateCode;

    @Column(name="consulting_date")
    private Timestamp consultingDate;

    @Column(name="reservation_date")
    private Timestamp reservationDate;

    @Column(name="travel_start_date")
    private Timestamp travelStartDate;

    @Column(name="travel_end_date")
    private Timestamp travelEndDate;

    @Column(name="number_of_people")
    private Integer numberOfPeople;

    @Column(name="with_children", columnDefinition = "TINYINT", length=1)
    private Integer withChildren;

    @Column(name="with_elderly", columnDefinition = "TINYINT", length=1)
    private Integer withElderly;

    @Column(name="with_disabled", columnDefinition = "TINYINT", length=1)
    private Integer withDisabled;

    private String note;

    @Builder
    public Reservation(User userId, Guide guideId, Timestamp consultingDate, Timestamp reservationDate, Timestamp travelStartDate, Timestamp travelEndDate, int numberOfPeople, int withChildren, int withElderly, int withDisabled, String note, String stateCode) {
        this.userId = userId;
        this.guideId = guideId;
        this.consultingDate = consultingDate;
        this.reservationDate = reservationDate;
        this.travelStartDate = travelStartDate;
        this.travelEndDate = travelEndDate;
        this.numberOfPeople = numberOfPeople;
        this.withChildren = withChildren;
        this.withElderly = withElderly;
        this.withDisabled = withDisabled;
        this.note = note;
        this.stateCode = stateCode;
    }
}
