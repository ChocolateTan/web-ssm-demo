package com.ssm.serviceImpl;

import com.ssm.bean.User;
import com.ssm.bean.UserExample;
import com.ssm.dao.UserMapper;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by don on 5/21/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteUser(int id) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(id);
        userMapper.deleteByExample(userExample);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.selectByExample(null);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

}
