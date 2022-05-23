package com.nexon.onestop.service.impl;

import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.repository.RoleRepository;
import com.nexon.onestop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Role getRole(long id) {
        return roleRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 권한을 찾을 수 없습니다.");
                });
    }

    @Override
    @Transactional
    public Role getRolename(String roleName) {

        return   roleRepository.findByroleName(roleName);
    }

    @Override
    @Transactional
    public List<Role> getListRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Role> getPageRoles(String searchText, Pageable pageable) {
        return roleRepository.findByRoleNameContaining(searchText, pageable);
    }

    @Transactional
    public void createRole(Role role){

        roleRepository.save(role);
    }

    @Transactional
    public void deleteRole(long id) {

        roleRepository.deleteById(id);
    }
}