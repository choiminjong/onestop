package com.nexon.onestop.service;

import com.nexon.onestop.domain.entity.Account;
import com.nexon.onestop.domain.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    Role getRole(long id);
    Role getRolename(String roleName);
    List<Role> getListRoles();
    Page<Role> getPageRoles(String searchText , Pageable pageable);
    void createRole(Role role);
    void deleteRole(long id);
}
