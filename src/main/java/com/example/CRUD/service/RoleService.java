package com.example.CRUD.service;

import com.example.CRUD.model.Role;

import java.util.List;

public interface RoleService {

    public boolean add(Role role);
    public List<Role> getList();
    public Role getRole(Long id);
    public void deleteRole(Long id);
    public void editRole(Role role);
    List<Role> listByRole(List<String> name);
}
