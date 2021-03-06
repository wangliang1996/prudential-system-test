package com.wliang.prudential.controller;

import com.wliang.prudential.dto.CarBookInfoDto;
import com.wliang.prudential.service.ICarService;
import com.wliang.prudential.common.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private ICarService carService;

    @RequestMapping(value = "book",method = RequestMethod.POST)
    public WrapperResponse book(@RequestBody CarBookInfoDto carBookInfoDto){
        //check param
        Assert.notNull(carBookInfoDto,"book param can not null");
        Assert.notNull(carBookInfoDto.getCarMode(),"book param can not null");
        Assert.notNull(carBookInfoDto.getPhone(),"phone can not null");
        Assert.notNull(carBookInfoDto.getBookStartTime(),"book start time can not null");
        Assert.notNull(carBookInfoDto.getBookEndTime(),"book end time can not null");
        Assert.notNull(carBookInfoDto.getBookingNum(),"book number can not null");
        carService.bookCar(carBookInfoDto);
        return WrapperResponse.success();
    }
}
