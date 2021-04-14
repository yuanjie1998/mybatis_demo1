package com.mybatis.demo1;

import com.mybatis.demo1.entity.vo.HolidayVo;
import com.mybatis.demo1.util.HolidayUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    HolidayUtil holidayUtil;

    @Test
    void contextLoads() {
    }

    //测试今天是否为节假日
    @Test
    public void testHoliday(){
        boolean resoult = holidayUtil.getTodayInfo();
        System.out.println(resoult);
        if (resoult == true){
            //今天是节假期
            System.out.println("今天是节假期...");
        }else if (resoult == false){
            System.out.println("不是是节假期...");
        }
    }
}
