package com.wliang.prudential.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("car_info")
public class CarInfoDo implements Serializable {
    private int id;

    private String carMode;

    private int stock;
}
