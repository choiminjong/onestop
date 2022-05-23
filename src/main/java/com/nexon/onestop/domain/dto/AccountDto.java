package com.nexon.onestop.domain.dto;

import com.nexon.onestop.domain.audit.BaseTimeEntity;
import com.nexon.onestop.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String id;
    private String username;
    private String email;
    private String password;
    private List<String> roles;
}

