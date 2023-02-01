package com.idle.gaza.db.entity;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="dayoff")
public class DayOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dayoff_id")
    private Integer dayOffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="guide_id")
    private Guide guide;

    @Column(name="dayoff_date")
    private LocalDate dayOffDate;

    @Builder
    public DayOff(Integer dayOffId, Guide guide, LocalDate dayOffDate) {
        this.dayOffId = dayOffId;
        this.guide = guide;
        this.dayOffDate = dayOffDate;
    }

    public DayOff() {

    }

    public Guide getGuide() {
        return guide;
    }

    public int getDayOffId() {
        return dayOffId;
    }

    public void setDayOffId(int dayOffId) {
        this.dayOffId = dayOffId;
    }

    public LocalDate getDayOffDate() {
        return dayOffDate;
    }

    public void setDayOffDate(LocalDate dayOffDate) {
        this.dayOffDate = dayOffDate;
    }



}
