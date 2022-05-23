package com.nexon.onestop.controller.api.admin;

import com.nexon.onestop.domain.dto.AccountDto;
import com.nexon.onestop.domain.dto.DelegateDto;
import com.nexon.onestop.domain.dto.ResourcesDto;
import com.nexon.onestop.domain.dto.ResponseDto;
import com.nexon.onestop.domain.entity.Delegate;
import com.nexon.onestop.domain.entity.Resources;
import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.service.impl.DelegateServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/admin")
public class DelegateManageApiController {

    @Autowired
    private DelegateServiceImpl delegateServiceImpl;

    @PostMapping(value="/delegate")
    public ResponseDto<Integer> modifyDelegate(@RequestBody DelegateDto delegateDto) throws Exception {

        delegateServiceImpl.modifydelegate(delegateDto);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping(value="/delegate/member")
    public ResponseDto<Integer> addDelegateUser(@RequestBody DelegateDto delegateDto) throws Exception {

        delegateServiceImpl.addDelegateUser(delegateDto);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping(value="/delegate/group")
    public ResponseDto<Integer> createDelegate(@RequestBody DelegateDto delegateDto) throws Exception {

        delegateServiceImpl.createDelegate(delegateDto);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
