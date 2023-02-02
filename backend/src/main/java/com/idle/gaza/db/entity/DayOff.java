package com.idle.gaza.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dayoff")
@Setter
@Getter
public class DayOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dayoff_id")
    private Integer dayOffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="guide_id")
    private Guide guide;

    @Column(name="dayoff_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOffDate;

    @Builder
    public DayOff(Integer dayOffId, Guide guide, LocalDate dayOffDate) {
        this.dayOffId = dayOffId;
        this.guide = guide;
        this.dayOffDate = dayOffDate;
    }

    public DayOff() {

    }


}
