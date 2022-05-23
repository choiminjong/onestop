package com.nexon.onestop.service.impl;

import com.nexon.onestop.domain.entity.Resources;
import com.nexon.onestop.repository.ResourcesRepository;
import com.nexon.onestop.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    @Override
    @Transactional
    public Resources getResources(long id) {
        Resources resources = resourcesRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("리소스를 찾을 수 없습니다.");
                });
        return resources;
    }

    @Override
    @Transactional
    public List<Resources> getResources() {
        return resourcesRepository.findAll(Sort.by(Sort.Order.asc("orderNum")));
    }

    @Override
    public Page<Resources> getPageResources(Pageable pageable) {
        return resourcesRepository.findPageResources(pageable);
    }

    @Override
    @Transactional
    public void createResources(Resources resources) {
        resourcesRepository.save(resources);
    }

    @Override
    @Transactional
    public void deleteResources(long id) {
        resourcesRepository.deleteById(id);
    }
}
