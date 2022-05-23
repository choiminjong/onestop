package com.nexon.onestop.controller.api.auth;

import com.nexon.onestop.domain.dto.ResponseDto;
import com.nexon.onestop.domain.entity.Account;
import com.nexon.onestop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApiController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/auth/join")
    public ResponseDto<Integer> save(@RequestBody Account account) {
        userServiceImpl.createUser(account);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
