package com.mybatis.demo1.dao;

import com.mybatis.demo1.entity.Trait;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author yuan jie
 * @Date 2021/4/4 19:38
 */
@Mapper
public interface TraitDao {
    /**
     * 新增traits类
     * fruits_id 为 外键
     * @param traitList
     * @return
     */
   Integer insertTrait (List<Trait> traitList);
}
