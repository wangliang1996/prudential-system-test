package com.wliang.prudential.Service.impl;

import com.wliang.prudential.Dao.CarDao;
import com.wliang.prudential.Dto.CarBookInfoDto;
import com.wliang.prudential.Service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarDao carDao;

    @Override
    public boolean bookCar(CarBookInfoDto carBookInfoDto) {
        //check carMode stock
        carDao.reduceCarStock(carBookInfoDto.getCarMode(),carBookInfoDto.getBookingNum());
        System.out.println(carBookInfoDto.getPhone()+" book "+carBookInfoDto.getBookingNum()+" "+carBookInfoDto.getCarMode());
        return true;
    }

    @Override
    public boolean cancelBookCar(CarBookInfoDto carBookInfoDto) {
        carDao.releaseCarStock(carBookInfoDto.getCarMode(),carBookInfoDto.getBookingNum());
        System.out.println(carBookInfoDto.getPhone()+" cancel book "+carBookInfoDto.getBookingNum()+" "+carBookInfoDto.getCarMode());
        return true;
    }
}
