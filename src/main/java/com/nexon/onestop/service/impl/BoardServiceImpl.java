package com.nexon.onestop.service.impl;

import com.nexon.onestop.domain.dto.BoardDto;
import com.nexon.onestop.domain.entity.Account;
import com.nexon.onestop.domain.entity.Board;
import com.nexon.onestop.domain.entity.Category;
import com.nexon.onestop.domain.entity.Delegate;
import com.nexon.onestop.repository.BoardRepository;
import com.nexon.onestop.repository.CategoryRepository;
import com.nexon.onestop.service.BoardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Page<Board> getPageBoard(String searchText, Pageable pageable) {
        return boardRepository.findByTitleContaining(searchText, pageable);
    }

    @Override
    @Transactional
    public void createBoard(BoardDto boardDto) {

        Category category = categoryRepository.findByCategoryName(boardDto.getCategory());

        ModelMapper modelMapper = new ModelMapper();
        Board board = modelMapper.map(boardDto, Board.class);
        board.setCategory(category);

        boardRepository.save(board);
    }

    @Override
    @Transactional
    public Board getBoard(long id) {
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.");
                });
    }

    @Override
    @Transactional
    public void deleteBoard(long id) {

        boardRepository.deleteById(id);
    }
}
