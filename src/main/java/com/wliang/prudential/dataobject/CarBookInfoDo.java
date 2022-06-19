package com.wliang.prudential.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("car_book_info")
public class CarBookInfoDo implements Serializable {
    private int id;

    private String carMode;

    private String phone;

    private int  bookNum;

    private Date bookStartTime;

    private Date bookEndTime;

    private Date createTime;

    private Date updateTime;
}
