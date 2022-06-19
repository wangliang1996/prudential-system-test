package com.wliang.prudential.dto;

import java.io.Serializable;

public class CarBookInfoDto implements Serializable {
    private String carMode;

    private int bookingNum;

    private String phone;

    public CarBookInfoDto(String carMode, int bookingNum, String phone) {
        this.carMode = carMode;
        this.bookingNum = bookingNum;
        this.phone = phone;
    }

    public String getCarMode() {
        return carMode;
    }

    public void setCarMode(String carMode) {
        this.carMode = carMode;
    }

    public int getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(int bookingNum) {
        this.bookingNum = bookingNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
