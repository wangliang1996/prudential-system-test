package com.wliang.prudential.Controller;

import com.wliang.prudential.Dto.CarBookInfoDto;
import com.wliang.prudential.Service.ICarService;
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
        carService.bookCar(carBookInfoDto);
        return WrapperResponse.success();
    }

    @RequestMapping(value = "cancelBook",method = RequestMethod.POST)
    public WrapperResponse cancelBook(@RequestBody CarBookInfoDto carBookInfoDto){
        Assert.notNull(carBookInfoDto,"cancel book param can not null");
        carService.cancelBookCar(carBookInfoDto);
        return WrapperResponse.success();
    }
}
