package com.nexon.onestop.controller.view.admin;

import com.nexon.onestop.domain.dto.RoleDto;
import com.nexon.onestop.domain.entity.Account;
import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.service.RoleService;
import com.nexon.onestop.service.impl.RoleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RoleManagerController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;


    @GetMapping(value="/roles")
    public String getRoles(Model model,
                           @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String searchText ){

        Page<Role> roles = roleServiceImpl.getPageRoles(searchText,pageable);

        int startPage = Math.max(1,roles.getPageable().getPageNumber() - 8);
        int endPage = Math.min(roles.getTotalPages(), roles.getPageable().getPageNumber() + 8);

        model.addAttribute("roles",roles);
        model.addAttribute("endPage",endPage);
        model.addAttribute("startPage", startPage);

        return "admin/role/list";
    }



    @GetMapping(value="/roles/register")
    public String viewRoles(Model model) throws Exception {
        RoleDto role = new RoleDto();
        model.addAttribute("role", role);
        return "admin/role/detail";
    }


    @GetMapping(value="/roles/{id}")
    public String getRole(@PathVariable String id, Model model) throws Exception {

        Role role = roleServiceImpl.getRole(Long.valueOf(id));

        ModelMapper modelMapper = new ModelMapper();
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);
        model.addAttribute("role", roleDto);

        return "admin/role/detail";
    }
}
