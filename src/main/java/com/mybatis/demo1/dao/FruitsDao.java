package com.mybatis.demo1.dao;

import com.mybatis.demo1.entity.Fruits;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author yuan jie
 * @Date 2021/4/2 13:26
 */
@Mapper
public interface FruitsDao {
    /**
     * 新增水果
     * @param fruits
     * @return
     */
    Integer insertFruits(Fruits fruits);

    /**
     * 根据id查询水果
     * @return
     */
    List<Fruits> selectAllFruits(String id);

    /**
     * 通过Fruits的id值查找特征Trait的值 1：n
     * @param id
     * @return
     */
    List<Fruits> selectTraitById(String id);
}
