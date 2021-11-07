package com.peaksoft.service;

import com.peaksoft.dao.RoleDao;
import com.peaksoft.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    public final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public void edit(Role role) {
        roleDao.edit(role);
    }

    @Override
    public void save(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getById(long id) {
        return roleDao.getByID(id);
    }

    @Override
    public Role getByName(String userName) {
        return roleDao.getByRole(userName);
    }
}
