package com.ssm.service;

import com.ssm.bean.User;

import java.util.List;

/**
 * Created by don on 5/21/17.
 */
public interface UserService {

    void insertUser(User user);

    void deleteUser(int id);

    User findUserById(Integer id);

    List<User> findAllUsers();

    void updateUser(User user);
}
