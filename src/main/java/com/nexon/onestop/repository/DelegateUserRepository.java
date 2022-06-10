package com.nexon.onestop.repository;

import com.nexon.onestop.domain.entity.Delegate;
import com.nexon.onestop.domain.entity.DelegateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DelegateUserRepository extends JpaRepository<DelegateUser,Long> {

}
