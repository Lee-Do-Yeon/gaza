package com.idle.gaza.db.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name="dayoff")
public class DayOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dayoff_id")
    private Integer dayOffId;

    @ManyToOne
    @JoinColumn(name="guide_id")
    private Guide guide;

    @Column(name="dayoff_date")
    private LocalDate dayOffDate;

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
