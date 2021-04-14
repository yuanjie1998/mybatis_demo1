package com.mybatis.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 特征类
 * 与 fruits 类  1： n
 * @Author yuan jie
 * @Date 2021/4/4 19:09
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Trait {
    private String id;
    private String shape; //形状
    private String fruits_id;//水果的id （外键）
}
