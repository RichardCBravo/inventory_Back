package com.nexos.inventory.domain;

import jakarta.persistence.Column;

import java.util.List;

public class PositionDto {
    private int positionId;

    private String name;


    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
