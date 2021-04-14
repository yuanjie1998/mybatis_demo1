package com.mybatis.demo1.Controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.mybatis.demo1.entity.Fruits;
import com.mybatis.demo1.entity.RetEntity;
import com.mybatis.demo1.exception.IllegaException;
import com.mybatis.demo1.service.FruitsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author yuan jie
 * @Date 2021/4/2 13:31
 */
@Slf4j
@RestController
@RequestMapping("/Fruits")
public class FruitsController {
    @Autowired
    FruitsService fruitsService;

    /**
     * 新增水果
     * @return
     */
    @PostMapping("/insertFruits")
    public RetEntity insertFruits() {
        //建造者模式
        Fruits fruits = new Fruits()
                .setId(IdUtil.simpleUUID())
                .setName("火龙果")
                .setStoreDate(new Date());
        Integer insertFruits = fruitsService.insertFruits(fruits);
        //得到返回的id主键值 新增水果的id值：77fa00a621e84e518c42e5114cde6365
        log.info("新增水果的id值：{}",fruits.getId());
        //jdk8新特性，解决空指针异常
        Integer result = Optional.ofNullable(insertFruits).map(Integer::intValue).orElse(0);
        if (result == 0){
            throw new IllegaException("新增水果失败！");
        }
        return RetEntity.ok().setBody(result);
    }

    /**
     * 传入fruits的id
     * 根据id查询水果
     * @return
     * {
     *     "code": 200,
     *     "body": [
     *         {
     *             "id": "fcd1ee2159074eecbd853f5f10a2a9dd",
     *             "name": "袁杰",
     *             "storeDate": "2021-04-02T00:00:00.000+08:00",
     *             "card": {
     *                 "id": "fcd1ee2159074eecbd853f5f10a2a9dd",
     *                 "location": "上海",
     *                 "fruits_id": "fcd1ee2159074eecbd853f5f10a2a9dd"
     *             }
     *         }
     *     ],
     *     "timestamp": "2021-04-02 18:31:59",
     *     "status": true,
     *     "message": "成功！"
     * }
     */
    @GetMapping("/selectAllFruits")
    public RetEntity selectAllFruits() {
        String id = "fcd1ee2159074eecbd853f5f10a2a9dd";
        List<Fruits> fruitsList = fruitsService.selectAllFruits(id);
        if (CollUtil.isEmpty(fruitsList)){
            throw new IllegaException("查询水果失败，无数据！");
        }
        for (Fruits fruits :fruitsList){
            Date storeDate = fruits.getStoreDate();
            log.info("打印的Date时间："+storeDate); //Fri Apr 02 00:00:00 CST 2021
        }
        return RetEntity.ok().setBody(fruitsList);
    }

    /**
     * 通过Fruits的id值查找特征的值 1：n
     * @return
     * {
     *     "code": 200,
     *     "body": [
     *         {
     *             "id": "fcd1ee2159074eecbd853f5f10a2a9dd",
     *             "name": "苹果",
     *             "storeDate": "2021-04-02T00:00:00.000+08:00",
     *             "card": null,
     *             "traits": [
     *                 {
     *                     "id": "199c700fbac04c1cab05ad190a39246c",
     *                     "shape": "憋的",
     *                     "fruits_id": "fcd1ee2159074eecbd853f5f10a2a9dd"
     *                 },
     *                 {
     *                     "id": "7fff2522191f431c9f824cc727cf7997",
     *                     "shape": "圆的",
     *                     "fruits_id": "fcd1ee2159074eecbd853f5f10a2a9dd"
     *                 }
     *             ]
     *         }
     *     ],
     *     "timestamp": "2021-04-05 18:17:57",
     *     "status": true,
     *     "message": "成功！"
     * }
     */
    @GetMapping("/selectTraitById/{happy}")
    public RetEntity selectTraitById(@PathVariable(value = "happy") String id){
        List<Fruits> fruitsList = fruitsService.selectTraitById(id);
        if (CollUtil.isEmpty(fruitsList)){
            throw new IllegaException("查询Trait数据失败！");
        }
        return RetEntity.ok().setBody(fruitsList);
    }
}
