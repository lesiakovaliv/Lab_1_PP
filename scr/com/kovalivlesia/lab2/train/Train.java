package com.kovalivlesia.lab2.train;

import java.time.LocalTime;

public class Train {
    private Integer number;
    private String destination;
    private LocalTime time;
    private Integer totalSeats;
    private Integer plackartSeats;
    private Integer cupeSeats;
    private Integer luxSeats;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getPlackartSeats() {
        return plackartSeats;
    }

    public void setPlackartSeats(Integer plackartSeats) {
        this.plackartSeats = plackartSeats;
    }

    public Integer getCupeSeats() {
        return cupeSeats;
    }

    public void setCupeSeats(Integer cupeSeats) {
        this.cupeSeats = cupeSeats;
    }

    public Integer getLuxSeats() {
        return luxSeats;
    }

    public void setLuxSeats(Integer luxSeats) {
        this.luxSeats = luxSeats;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "Train{" +
                "number=" + number +
                ", destination='" + destination + '\'' +
                ", time=" + time +
                ", mainSeats=" + totalSeats +
                ", plackartSeats=" + plackartSeats +
                ", cupeSeats=" + cupeSeats +
                ", luxSeats=" + luxSeats +
                "}\n";
    }
}
