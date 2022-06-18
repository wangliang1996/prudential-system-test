package com.wliang.prudential.Service;

import com.wliang.prudential.Dto.CarBookInfoDto;

public interface ICarService {
    boolean bookCar(CarBookInfoDto carBookInfoDto);

    boolean cancelBookCar(CarBookInfoDto carBookInfoDto);
}
