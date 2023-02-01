package com.idle.gaza.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class Review {
    @Id
    @Column(name="review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservationId;

    private String content;
    @Column(name="created_date")
    private Timestamp createdDate;
    private int score;

    @Builder
    public Review(Reservation reservationId, String content, int score) {
        this.reservationId = reservationId;
        this.content = content;
        this.score = score;
    }
}
