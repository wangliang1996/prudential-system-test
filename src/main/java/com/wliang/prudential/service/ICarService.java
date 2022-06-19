package com.wliang.prudential.service;

import com.wliang.prudential.dto.CarBookInfoDto;

public interface ICarService {
    boolean bookCar(CarBookInfoDto carBookInfoDto);

    boolean cancelBookCar(CarBookInfoDto carBookInfoDto);
}
