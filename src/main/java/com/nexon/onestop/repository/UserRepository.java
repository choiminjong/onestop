package com.nexon.onestop.repository;

import com.nexon.onestop.domain.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
    int countByUsername(String username);

    //username  필드 like 검색
    Page<Account> findByUsernameContaining(String username, Pageable pageable);
}
