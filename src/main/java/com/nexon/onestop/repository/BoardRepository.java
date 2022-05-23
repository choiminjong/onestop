package com.nexon.onestop.repository;

import com.nexon.onestop.domain.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

    //title  필드 like 검색
    Page<Board> findByTitleContaining(String title, Pageable pageable);

}
