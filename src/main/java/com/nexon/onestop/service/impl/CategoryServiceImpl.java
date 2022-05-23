package com.nexon.onestop.service.impl;

import com.nexon.onestop.domain.entity.Category;
import com.nexon.onestop.repository.CategoryRepository;
import com.nexon.onestop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Page<Category> getPageCategory(String searchText, Pageable pageable) {
        return categoryRepository.findByCategoryNameContaining(searchText, pageable);
    }

    @Override
    @Transactional
    public List<Category> getCategoryes() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    @Transactional
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category getCategory(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다.");
                });
    }

    @Override
    @Transactional
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

}