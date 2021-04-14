package com.mybatis.demo1.service.serviceImpl;

import com.mybatis.demo1.dao.FruitsDao;
import com.mybatis.demo1.entity.Fruits;
import com.mybatis.demo1.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yuan jie
 * @Date 2021/4/2 13:29
 */
@Service
public class FruitsServiceImpl implements FruitsService {
    @Autowired
    FruitsDao fruitsDao;

    /**
     * 新增水果
     * @param fruits
     * @return
     */
    @Override
    public Integer insertFruits(Fruits fruits) {
        Integer insertFruits = fruitsDao.insertFruits(fruits);
        return insertFruits;
    }

    /**
     * 查询所有水果
     * @return
     */
    @Override
    public List<Fruits> selectAllFruits(String id) {
        List<Fruits> fruitsList = fruitsDao.selectAllFruits(id);
        return fruitsList;
    }

    @Override
    public List<Fruits> selectTraitById(String id) {
        List<Fruits> fruitsList = fruitsDao.selectTraitById(id);
        return fruitsList;
    }
}
