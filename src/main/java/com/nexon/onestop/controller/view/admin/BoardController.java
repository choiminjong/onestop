package com.nexon.onestop.controller.view.admin;

import com.nexon.onestop.domain.dto.BoardDto;
import com.nexon.onestop.domain.dto.CategoryDto;
import com.nexon.onestop.domain.entity.Board;
import com.nexon.onestop.domain.entity.Category;
import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.service.impl.BoardServiceImpl;
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

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BoardController {

    @Autowired
    private BoardServiceImpl boardServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping(value="/boards")
    public String getBoards(Model model,
                              @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                              @RequestParam(required = false, defaultValue = "") String searchText ){

        Page<Board> boards = boardServiceImpl.getPageBoard(searchText,pageable);

        int startPage = Math.max(1,boards.getPageable().getPageNumber() - 8);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 8);

        model.addAttribute("boards",boards);
        model.addAttribute("endPage",endPage);
        model.addAttribute("startPage", startPage);

        return "admin/board/list";
    }

    @GetMapping(value="/board/register")
    public String viewCategory(Model model) throws Exception {

        List<Category> categoryes = categoryServiceImpl.getCategoryes();
        BoardDto board = new BoardDto();
        model.addAttribute("board", board);
        model.addAttribute("categoryes", categoryes);

        return "admin/board/detail";
    }

    @GetMapping(value="/boards/{id}")
    public String getBoard(@PathVariable String id, Model model) throws Exception {

        List<Category> categoryes = categoryServiceImpl.getCategoryes();
        Board board = boardServiceImpl.getBoard(Long.valueOf(id));
        System.out.println("board ### = " + board);
        ModelMapper modelMapper = new ModelMapper();
        BoardDto  boardDto= modelMapper.map(board, BoardDto.class);

        model.addAttribute("categoryes", categoryes);
        model.addAttribute("board", boardDto);

        return "admin/category/detail";
    }


}
