package com.nexon.onestop.controller.api.admin;

import com.nexon.onestop.domain.dto.CategoryDto;
import com.nexon.onestop.domain.dto.ResponseDto;
import com.nexon.onestop.domain.dto.RoleDto;
import com.nexon.onestop.domain.entity.Category;
import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.service.impl.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class CategoryManagerApiController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping(value="/category")
    public ResponseDto<Integer> createRole(@RequestBody CategoryDto categoryDto) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        Category category = modelMapper.map(categoryDto, Category.class);
        categoryServiceImpl.createCategory(category);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping(value="/category/{id}")
    public ResponseDto<Integer> modifyCategory(@RequestBody CategoryDto categoryDto ,
                                               @PathVariable(value = "id") Long id) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setId(id);
        categoryServiceImpl.createCategory(category);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping(value="/category/{id}")
    public ResponseDto<Integer> removeCategory(@PathVariable String id) throws Exception {

        categoryServiceImpl.deleteCategory(Long.valueOf(id));

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
