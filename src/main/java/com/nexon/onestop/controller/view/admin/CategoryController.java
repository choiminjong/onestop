package com.nexon.onestop.controller.view.admin;

import com.nexon.onestop.domain.dto.CategoryDto;
import com.nexon.onestop.domain.dto.RoleDto;
import com.nexon.onestop.domain.entity.Category;
import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.service.impl.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping(value="/category")
    public String getCategory(Model model,
                           @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String searchText ){

        Page<Category> categoryes = categoryServiceImpl.getPageCategory(searchText,pageable);

        int startPage = Math.max(1,categoryes.getPageable().getPageNumber() - 8);
        int endPage = Math.min(categoryes.getTotalPages(), categoryes.getPageable().getPageNumber() + 8);

        model.addAttribute("categoryes",categoryes);
        model.addAttribute("endPage",endPage);
        model.addAttribute("startPage", startPage);

        return "admin/category/list";
    }

    @GetMapping(value="/category/register")
    public String viewCategory(Model model) throws Exception {
        CategoryDto category = new CategoryDto();
        model.addAttribute("category", category);
        return "admin/category/detail";
    }

    @GetMapping(value="/category/{id}")
    public String getCategory(@PathVariable String id, Model model) throws Exception {

        Category category = categoryServiceImpl.getCategory(Long.valueOf(id));
        ModelMapper modelMapper = new ModelMapper();
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        model.addAttribute("category", categoryDto);

        return "admin/category/detail";
    }

}
