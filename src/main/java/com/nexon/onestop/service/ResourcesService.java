package com.nexon.onestop.service;

import com.nexon.onestop.domain.entity.Resources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResourcesService {
    Resources getResources(long id);
    List<Resources> getResources();
    Page<Resources> getPageResources(Pageable pageable);
    void createResources(Resources Resources);
    void deleteResources(long id);
}