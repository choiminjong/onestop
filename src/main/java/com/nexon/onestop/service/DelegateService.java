package com.nexon.onestop.service;

import com.nexon.onestop.domain.dto.AccountDto;
import com.nexon.onestop.domain.dto.DelegateDto;
import com.nexon.onestop.domain.entity.Delegate;

import java.util.List;

public interface DelegateService {
    List<Delegate> getDelegates();
    DelegateDto getDelegate(Long id);
    void addDelegateUser(DelegateDto delegateDto);
    void createDelegate(DelegateDto delegateDto);
    void modifydelegate(DelegateDto delegateDto);

}
