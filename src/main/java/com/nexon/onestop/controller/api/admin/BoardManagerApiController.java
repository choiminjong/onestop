package com.nexon.onestop.controller.api.admin;

import com.nexon.onestop.domain.dto.BoardDto;
import com.nexon.onestop.domain.dto.CategoryDto;
import com.nexon.onestop.domain.dto.ResponseDto;
import com.nexon.onestop.domain.entity.Board;
import com.nexon.onestop.domain.entity.Category;
import com.nexon.onestop.service.impl.BoardServiceImpl;
import com.nexon.onestop.service.impl.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class BoardManagerApiController {

    @Autowired
    private BoardServiceImpl boardServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping(value="/board")
    public ResponseDto<Integer> createRole(@RequestBody BoardDto boardDto) throws Exception {

        boardServiceImpl.createBoard(boardDto);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
