package com.kovalivlesia.models;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString(exclude = "id")
@AllArgsConstructor
public class Bank implements Pack {

    private Integer id;

    private Double volume;

    private Double volumeOfContent;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Double getVolume() {
        return volume;
    }

    @Override
    public Double getVolumeOfContent() {
        return volumeOfContent;
    }
}
