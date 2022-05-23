package com.nexon.onestop.repository;

import com.nexon.onestop.domain.entity.Resources;
import com.nexon.onestop.domain.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {

    @EntityGraph(attributePaths = { "roleSet" })
    @Query("select r from Resources r join fetch r.roleSet where r.resourceType = 'url' order by r.orderNum desc")
    List<Resources> findAllResources();

    @EntityGraph(attributePaths = { "roleSet" })
    @Query("select r from Resources r where r.resourceType = 'url' order by r.orderNum asc")
    Page<Resources> findPageResources(Pageable pageable);

}
