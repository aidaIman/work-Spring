package com.peaksoft.service;

import com.peaksoft.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    void edit(User user);

    void delete(User user);

    User getById(long id);

    User getByUsername(String userName);
}
