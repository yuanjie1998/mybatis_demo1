package com.mybatis.demo1.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 判断今天是否为节假日
 * 与工具类一起使用
 * @Author yuan jie
 * @Date 2021/4/6 13:54
 */
public class HolidayVo {
    /**
     * 是否是 休
     */
    private boolean isVacation = false;
    /**
     * 公历时间
     */
    private Date solarDate;

    public boolean isVacation() {
        return isVacation;
    }

    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }

    public Date getSolarDate() {
        return solarDate;
    }

    public void setSolarDate(Date solarDate) {
        this.solarDate = solarDate;
    }
}
