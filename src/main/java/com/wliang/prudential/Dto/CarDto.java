package com.wliang.prudential.Dto;

import java.io.Serializable;

public class CarDto implements Serializable {
    private String carMode;

    private int stock;

    public CarDto(String carMode, int stock) {
        this.carMode = carMode;
        this.stock = stock;
    }

    public String getCarMode() {
        return carMode;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
