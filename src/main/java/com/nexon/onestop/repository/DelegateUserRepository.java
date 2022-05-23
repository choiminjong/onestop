package com.nexon.onestop.repository;

import com.nexon.onestop.domain.entity.Delegate;
import com.nexon.onestop.domain.entity.DelegateUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelegateUserRepository extends JpaRepository<DelegateUser,Long> {

}
