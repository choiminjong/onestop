package com.nexon.onestop.controller.api.admin;

import com.nexon.onestop.domain.dto.AccountDto;
import com.nexon.onestop.domain.dto.ResponseDto;
import com.nexon.onestop.service.impl.RoleServiceImpl;
import com.nexon.onestop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserManagerApiController {

    @Autowired
    private UserServiceImpl userServiceImpl;

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
