package com.nexon.onestop.repository;

import com.nexon.onestop.domain.entity.Category;
import com.nexon.onestop.domain.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    //roleName  필드 like 검색
    Page<Category> findByCategoryNameContaining(String categoryName, Pageable pageable);

    Category findByCategoryName(String categoryName);
}
