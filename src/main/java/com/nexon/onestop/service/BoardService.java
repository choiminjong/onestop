package com.nexon.onestop.service;

import com.nexon.onestop.domain.dto.BoardDto;
import com.nexon.onestop.domain.entity.Board;
import com.nexon.onestop.domain.entity.Category;
import com.nexon.onestop.domain.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    Page<Board> getPageBoard(String searchText , Pageable pageable);
    void createBoard(BoardDto boardDto);
    Board getBoard(long id);
    void deleteBoard(long id);
}
