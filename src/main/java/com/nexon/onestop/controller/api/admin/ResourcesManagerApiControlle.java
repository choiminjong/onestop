package com.nexon.onestop.controller.api.admin;

import com.nexon.onestop.domain.dto.ResourcesDto;
import com.nexon.onestop.domain.dto.ResponseDto;
import com.nexon.onestop.domain.dto.RoleDto;
import com.nexon.onestop.domain.entity.Resources;
import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.repository.RoleRepository;

import com.nexon.onestop.security.metadatasource.UrlFilterInvocationSecurityMetadataSource;
import com.nexon.onestop.service.ResourcesService;
import com.nexon.onestop.service.RoleService;
import com.nexon.onestop.service.impl.ResourcesServiceImpl;
import com.nexon.onestop.service.impl.RoleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/admin")
public class ResourcesManagerApiControlle {

    @Autowired
    private ResourcesServiceImpl resourcesServiceImpl;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @Autowired
    private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;

    @PostMapping(value="/resources")
    public ResponseDto<Integer> createResources(@RequestBody ResourcesDto resourcesDto) throws Exception {

        Role role =  roleServiceImpl.getRolename(resourcesDto.getRoleName());
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        ModelMapper modelMapper = new ModelMapper();
        Resources resources = modelMapper.map(resourcesDto, Resources.class);
        resources.setRoleSet(roles);

        resourcesServiceImpl.createResources(resources);
        urlFilterInvocationSecurityMetadataSource.reload();
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping(value="/resources/{id}")
    public ResponseDto<Integer> modifyResources(@RequestBody ResourcesDto resourcesDto ,
                                           @PathVariable(value = "id") Long id) throws Exception {

        Role role =  roleServiceImpl.getRolename(resourcesDto.getRoleName());
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        ModelMapper modelMapper = new ModelMapper();
        Resources resources = modelMapper.map(resourcesDto, Resources.class);
        resources.setId(id);
        resources.setRoleSet(roles);

        resourcesServiceImpl.createResources(resources);
        urlFilterInvocationSecurityMetadataSource.reload();
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
//
//    @GetMapping(value="/resources/delete/{id}")
//    public String removeResources(@PathVariable String id, Model model) throws Exception {
//
//        Resources resources = resourcesServiceImpl.getResources(Long.valueOf(id));
//        resourcesServiceImpl.deleteResources(Long.valueOf(id));
//
//        return "redirect:/admin/resources";
//    }

}
