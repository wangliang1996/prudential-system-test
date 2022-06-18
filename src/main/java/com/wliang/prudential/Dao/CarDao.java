package com.wliang.prudential.Dao;

import com.wliang.prudential.Exception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class CarDao {
    public static ConcurrentHashMap<String, AtomicInteger> cars = new ConcurrentHashMap<>();

    static {
        cars.put("Toyota Camry",new AtomicInteger(2));
        cars.put("BMW 650",new AtomicInteger(2));
    }


    public boolean releaseCarStock(String carMode,int bookingNum){
        AtomicInteger stock = cars.get(carMode);
        int i = stock.intValue()+bookingNum;
        if(i > 2){
            throw new BusinessException(50001,"stock exception");
        }
        stock.compareAndSet(stock.intValue(),i);
        cars.put(carMode,stock);
        return true;
    }

    public boolean reduceCarStock(String carMode,int bookingNum){
        AtomicInteger stock = cars.get(carMode);
        int i = stock.intValue()-bookingNum;
        if(i >= 0){
            stock.compareAndSet(stock.intValue(),i);
            cars.put(carMode,stock);
            return true;
        }else{
            throw new BusinessException(50002,"car under stock");
        }
    }
}
