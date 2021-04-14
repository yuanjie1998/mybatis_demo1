package com.mybatis.demo1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * 与Card 类 1:1 关系
 * 与 Trait 类 1: n 关系
 * 水果类，测试Date属性的存取值
 * @Author yuan jie
 * @Date 2021/4/2 13:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //建造者模式
public class Fruits {
    private String id;
    private String name;
    @JsonFormat(
//            pattern ="yyyy-MM-dd HH:mm:ss",
            timezone ="GMT+8"
    )
    private Date storeDate;
    //关联关系 1:1
    private Card card;
    //关联关系 1:n
    private List<Trait> traits;

}
