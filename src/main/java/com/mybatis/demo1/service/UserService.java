package com.mybatis.demo1.service;

import com.mybatis.demo1.dao.UserDao;
import com.mybatis.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @Author yuan jie
 * @Date 2021/3/12 16:42
 */
public interface UserService {
     /**
      * 查询所有数据接口
      * @return
      */
     List<User> selectAll ();
     /**
      * 新增用户
      */
     Integer insertUser(User user);
     /**
      * 删除用户
      */
     Integer deleteUser(Integer id);
     /**
      * 根据id  update用户
      */
     Integer updateUser(User user);
     /**
      * 模糊查询
      */
     List<User> selectSomeUser (String name);
     /**
      * 根据姓名、年龄查询
      */
     List<User> findOneUser(String name,Integer age);
     /**
      * <foreach>元素
      * @param ids
      * @return
      */
     List<User> findAllByIds(List<Integer> ids);
     /**
      * 批量查询
      * Map类型的参数
      */
     List<User> findAllByMap(Map<String,Object> map);
}
