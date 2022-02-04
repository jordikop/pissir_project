package com.unipo.pissir.domain;

import javax.persistence.*;

@Entity
@Table(name = "TimeSlot", schema = "pissir")
public class TimeSlot {

    @Id
    @GeneratedValue
    @Column(name = "TimeSlotId")
    private Long id;
    @Column private long initTime;
    @Column private long endTime;



    public TimeSlot() {
    }

    public TimeSlot(long initTime, long endTime) {
        this.initTime = initTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", initTime=" + initTime +
                ", endTime=" + endTime +
                '}';
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }
    public long getInitTime() {
        return initTime;
    }

    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public  boolean isValid(){
        return initTime <=endTime;
    }
}
