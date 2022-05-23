package com.nexon.onestop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DelegateDto {
    private Long id;
    private String groupname;
    private String username;
    private List<String> delegateUsers;

}


