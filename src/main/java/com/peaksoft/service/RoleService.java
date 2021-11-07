package com.peaksoft.service;

import com.peaksoft.model.Role;

import java.util.List;

public interface RoleService{

    List<Role> getAllRoles();

    void edit(Role role);

    void save(Role role);

    Role getById(long id);

    Role getByName(String userName);
}
