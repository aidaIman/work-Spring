package com.peaksoft.dao;

import com.peaksoft.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();
    void add(Role role);
    void edit(Role role);
    Role getByID(long id);
    Role getByRole(String role);
}
