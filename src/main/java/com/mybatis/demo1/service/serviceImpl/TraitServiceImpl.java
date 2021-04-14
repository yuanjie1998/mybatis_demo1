package com.mybatis.demo1.service.serviceImpl;

import com.mybatis.demo1.dao.TraitDao;
import com.mybatis.demo1.entity.Trait;
import com.mybatis.demo1.service.TraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author yuan jie
 * @Date 2021/4/4 19:42
 */
@Service
public class TraitServiceImpl implements TraitService {
    @Autowired
    private TraitDao traitDao;

    /**
     * 根据外键fruits_id 新增Trait数据
     * @param traitList
     * @return
     */
    @Override
    public Integer insertTrait(List<Trait> traitList) {
        Integer integer = traitDao.insertTrait(traitList);
        return integer;
    }
}
