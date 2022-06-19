package com.wliang.prudential.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wliang.prudential.dataobject.CarInfoDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarInfoMapper extends BaseMapper<CarInfoDo> {
}
