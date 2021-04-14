package com.mybatis.demo1.service;

import com.mybatis.demo1.entity.Fruits;

import java.util.List;

/**
 * @Author yuan jie
 * @Date 2021/4/2 13:29
 */
public interface FruitsService {

    Integer insertFruits(Fruits fruits);

    /**
     * 根据id查询水果
     * @return
     */
    List<Fruits> selectAllFruits(String id);
    /**
     * 通过Fruits的id值查找特征的值 1：n
     * @param id
     * @return
     */
    List<Fruits> selectTraitById(String id);
}
