package com.wliang.prudential.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wliang.prudential.dataobject.CarBookInfoDo;
import com.wliang.prudential.dataobject.CarInfoDo;
import com.wliang.prudential.dto.CarBookInfoDto;
import com.wliang.prudential.exception.BusinessException;
import com.wliang.prudential.mapper.CarBookInfoMapper;
import com.wliang.prudential.mapper.CarInfoMapper;
import com.wliang.prudential.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarInfoMapper carInfoMapper;

    @Autowired
    private CarBookInfoMapper carBookInfoMapper;

    @Override
    public boolean bookCar(CarBookInfoDto carBookInfoDto) {
        //query car stock
        QueryWrapper<CarInfoDo> carInfoDoQueryWrapper = new QueryWrapper<>();
        carInfoDoQueryWrapper.eq("car_mode",carBookInfoDto.getCarMode());
        CarInfoDo carInfoDo = carInfoMapper.selectOne(carInfoDoQueryWrapper);
        //check car stock
        QueryWrapper<CarBookInfoDo> carBookInfoDoQueryWrapper = new QueryWrapper<>();
        carBookInfoDoQueryWrapper.select("sum(book_num) as bookNum")
                .eq("car_mode",carBookInfoDto.getCarMode())
                .and(wrapper -> wrapper.between("book_start_time",carBookInfoDto.getBookStartTime(),carBookInfoDto.getBookEndTime())
                .or().between("book_end_time",carBookInfoDto.getBookStartTime(),carBookInfoDto.getBookEndTime())
                .or().ge("book_start_time",carBookInfoDto.getBookStartTime()).le("book_end_time",carBookInfoDto.getBookEndTime())
                .or().le("book_start_time",carBookInfoDto.getBookStartTime()).ge("book_end_time",carBookInfoDto.getBookEndTime()));
        CarBookInfoDo carBookInfoDo = carBookInfoMapper.selectOne(carBookInfoDoQueryWrapper);
        if(carBookInfoDo != null
                && (carBookInfoDo.getBookNum() > carInfoDo.getStock() || (carBookInfoDo.getBookNum()+carBookInfoDto.getBookingNum()) > 2)){
            throw new BusinessException(50001,"not enough stock with car "+carBookInfoDto.getCarMode());
        }
        //insert book record
        CarBookInfoDo entity = new CarBookInfoDo();
        entity.setCarMode(carBookInfoDto.getCarMode());
        entity.setPhone(carBookInfoDto.getPhone());
        entity.setBookNum(carBookInfoDto.getBookingNum());
        entity.setBookStartTime(carBookInfoDto.getBookStartTime());
        entity.setBookEndTime(carBookInfoDto.getBookEndTime());
        carBookInfoMapper.insert(entity);
        return true;
    }

}
