package com.peaksoft.dao;

import com.peaksoft.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    void edit(User user);

    void delete(User user);

    User getById(long id);

    User getByUserName(String userName);
}
