package com.nexon.onestop.repository;

import com.nexon.onestop.domain.entity.Account;
import com.nexon.onestop.domain.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Long> {

    Role findByroleName(String name);

    @Override
    void delete(Role role);

    //roleName  필드 like 검색
    Page<Role> findByRoleNameContaining(String roleName, Pageable pageable);

}
