package com.mybatis.demo1.service.serviceImpl;

import com.mybatis.demo1.dao.UserDao;
import com.mybatis.demo1.entity.User;
import com.mybatis.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author yuan jie
 * @Date 2021/3/12 16:48
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> selectAll() {
        List<User> users = userDao.selectAll();
        return users;
    }

    @Override
    public Integer insertUser(User user) {
        Integer integer = userDao.insertUser(user);
        return integer;
    }

    @Override
    public Integer deleteUser(Integer id) {
        Integer deleteUser = userDao.deleteUser(id);
        return deleteUser;
    }

    @Override
    public Integer updateUser(User user) {
        Integer integer = userDao.updateUser(user);
        return integer;
    }

    @Override
    public List<User> selectSomeUser(String name) {
        List<User> users = userDao.selectSomeUser(name);
        return users;
    }

    @Override
    public List<User> findOneUser(String name, Integer age) {
        List<User> oneUser = userDao.findOneUser(name, age);
        return oneUser;
    }

    @Override
    public List<User> findAllByIds(List<Integer> ids) {
        List<User> allByIds = userDao.findAllByIds(ids);
        return allByIds;
    }

    @Override
    public List<User> findAllByMap(Map<String, Object> map) {
        List<User> allByMap = userDao.findAllByMap(map);
        return allByMap;
    }
}
