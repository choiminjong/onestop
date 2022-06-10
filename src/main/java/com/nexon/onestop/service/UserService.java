package com.nexon.onestop.service;

import com.nexon.onestop.domain.dto.AccountDto;
import com.nexon.onestop.domain.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void createUser(Account account);
    void modifyUser(AccountDto accountDto);
    Page<Account> getUsers(String searchText ,Pageable pageable);
    AccountDto getUser(Long id);
    void deleteUser(Long id);
    void validationDuplicationUser(Account account);
}
