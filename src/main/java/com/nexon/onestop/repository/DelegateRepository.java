package com.nexon.onestop.repository;

import com.nexon.onestop.domain.entity.Delegate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DelegateRepository extends JpaRepository<Delegate,Long> {
    Delegate findBygroupname(String groupname);
}
