package com.mybatis.demo1.service;

import com.mybatis.demo1.entity.Trait;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author yuan jie
 * @Date 2021/4/4 19:41
 */
public interface TraitService {
    /**
     * 新增Trait
     * @param traitList
     * @return
     */
    Integer insertTrait (List<Trait> traitList);
}
