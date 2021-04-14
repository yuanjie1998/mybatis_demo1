package com.mybatis.demo1.Controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.mybatis.demo1.entity.RetEntity;
import com.mybatis.demo1.entity.Trait;
import com.mybatis.demo1.exception.IllegaException;
import com.mybatis.demo1.service.TraitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author yuan jie
 * @Date 2021/4/4 19:44
 */
@Slf4j
@RestController
@RequestMapping("/trait")
public class TraitController {
    @Autowired
    TraitService traitService;

    /**
     * 1：n
     * 根据外键fruits_id 批量新增Trait数据
     * @return
     */
    @PostMapping("/insertTrait")
    public RetEntity insertTrait(@RequestBody Map<String,Object> map){
        //map中的list对象数据 list对象集合
        String trait = JSON.toJSONString(map.get("trait"));
        List<Trait> traitList = JSON.parseArray(trait, Trait.class);
        log.info("传入的traits数据：{}",traitList);
        for (Trait traits : traitList){
            //trait的id值需自己设置uuid
            traits.setId(IdUtil.simpleUUID());
            traits.setFruits_id(map.get("fruits_id").toString());
        }
        log.info("存入fruits_id的list对象集合：{}",traitList);
        //insertTrait可以改用map中的list集合作为参数
        Integer integer = traitService.insertTrait(traitList);
        if (CollUtil.isEmpty(traitList)){
            throw new IllegaException("新增Trait数据失败！");
        }
        return RetEntity.ok().setBody(integer);
    }

}
