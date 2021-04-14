package com.mybatis.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 此项目是mybatis的
 * @Author yuan jie
 * @Date 2021/3/12 15:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String hobby;
}
