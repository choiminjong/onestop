package com.nexon.onestop.controller.api.admin;

import com.nexon.onestop.domain.dto.AccountDto;
import com.nexon.onestop.domain.dto.ResponseDto;
import com.nexon.onestop.domain.entity.Account;
import com.nexon.onestop.service.impl.RoleServiceImpl;
import com.nexon.onestop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserManagerApiController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value="/serch/accounts")
    public Page<Account> getUsers(
        @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
        @RequestParam(required = false, defaultValue = "") String searchText) throws Exception {
        return userServiceImpl.getUsers(searchText,pageable);
        //return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


    @PostMapping(value="/accounts")
    public ResponseDto<Integer>  modifyUser(@RequestBody AccountDto accountDto) throws Exception {
        userServiceImpl.modifyUser(accountDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @GetMapping(value="/accounts/delete/{id}")
    public ResponseDto<Integer> removeUser(@PathVariable(value = "id") Long id) throws Exception {
        userServiceImpl.deleteUser(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
