package com.nexon.onestop.controller.view.admin;

import com.nexon.onestop.domain.dto.ResourcesDto;
import com.nexon.onestop.domain.entity.Resources;
import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.repository.RoleRepository;
import com.nexon.onestop.service.ResourcesService;
import com.nexon.onestop.service.RoleService;
import com.nexon.onestop.service.impl.ResourcesServiceImpl;
import com.nexon.onestop.service.impl.RoleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class ResourcesManagerController {

    @Autowired
    private ResourcesServiceImpl resourcesServiceImpl;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @GetMapping(value="/resources")
    public String getResources(Model model,
                               @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable)
                               throws Exception {

        Page<Resources> resources = resourcesServiceImpl.getPageResources(pageable);

        int startPage = Math.max(1,resources.getPageable().getPageNumber() - 8);
        int endPage = Math.min(resources.getTotalPages(), resources.getPageable().getPageNumber() + 8);

        model.addAttribute("resources",resources);
        model.addAttribute("endPage",endPage);
        model.addAttribute("startPage", startPage);

        return "admin/resource/list";
    }

    @GetMapping(value="/resources/register")
    public String viewRoles(Model model) throws Exception {

        List<Role> roleList = roleServiceImpl.getListRoles();

        ResourcesDto resources = new ResourcesDto();
        Set<Role> roleSet = new HashSet<>();
        //roleSet.add(new Role());
        resources.setRoleSet(roleSet);

        model.addAttribute("roleList", roleList);
        model.addAttribute("resources", resources);

        return "admin/resource/detail";
    }

    @GetMapping(value="/resources/{id}")
    public String getResources(@PathVariable String id, Model model) throws Exception {

        List<Role> roleList = roleServiceImpl.getListRoles();

        Resources resources = resourcesServiceImpl.getResources(Long.valueOf(id));
        ModelMapper modelMapper = new ModelMapper();
        ResourcesDto resourcesDto = modelMapper.map(resources, ResourcesDto.class);

        model.addAttribute("roleList", roleList);
        model.addAttribute("resources", resourcesDto);

        return "admin/resource/detail";
    }

}
