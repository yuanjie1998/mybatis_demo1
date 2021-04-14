package com.mybatis.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 与fruits1:1
 * @Author yuan jie
 * @Date 2021/4/2 17:17
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String id;
    private String location;
    private String fruits_id; //fruits主键作为外键
}
