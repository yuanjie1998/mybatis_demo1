package com.mybatis.demo1.Controller;

import cn.hutool.core.lang.UUID;
import com.mybatis.demo1.entity.User;
import com.mybatis.demo1.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yuan jie
 * @Date 2021/3/12 16:46
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/selectAll")
    public List<User> selectAll(){
        List<User> users = userService.selectAll();
        return users;
    }

    @PostMapping("/insertUser")
    public Integer insertUser(@RequestBody User user){
        System.out.println(user);
        Integer count = userService.insertUser(user);
        return count;
    }

    @PostMapping("/deleteUser")
    public Integer deleteUser(@RequestParam Integer id){
        Integer integer = userService.deleteUser(id);
        return integer;
    }

    @PostMapping("/updateUser")
    public Integer updateUser(@RequestBody User user){
        System.out.println(user);
        Integer integer = userService.updateUser(user);
        return integer;
    }
    @GetMapping("/selectSomeUser")
    public List<User> selectSomeUser(String name){
        System.out.println(name);
        List<User> users = userService.selectSomeUser(name);
        return users;
    }
    @PostMapping("/findOneUser")
    public List<User> findOneUser(@RequestBody User user){
        List<User> oneUser = userService.findOneUser(user.getName(), user.getAge());
        return oneUser;
    }

    @PostMapping("/findAllByIds")
    public List<User> findAllByIds(@RequestBody List<Integer> ids){
        List<User> allByIds = userService.findAllByIds(ids);
        System.out.println(allByIds);
        return allByIds;
    }

    @GetMapping("/findAllByMap")
    public List<User> findAllByMap (){
        Map<String,Object> map = new HashMap<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        map.put("title","testMap");
        map.put("ids",ids);
        List<User> allByMap = userService.findAllByMap(map);
        System.out.println(allByMap);
        return allByMap;
    }
}
