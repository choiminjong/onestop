package com.nexon.onestop.security.service;

import com.nexon.onestop.domain.entity.Resources;
import com.nexon.onestop.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class SecurityResourceService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    //권한과 자원정보를 가져온다.
    @Transactional
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList() {

        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resources> resourcesList = resourcesRepository.findAllResources();

        System.out.println("request resourcesList = " + resourcesList);

        resourcesList.forEach(re -> {
            List<ConfigAttribute> configAttributeList = new ArrayList<>();
            re.getRoleSet().forEach(role ->{
                //SecurityConfig  import org.springframework.security.access.SecurityConfig; 패키지 필요
                configAttributeList.add(new SecurityConfig(role.getRoleName())); // configAttributeList 구현체 기준으로 객체를 Role 계속 추가한다.
                result.put(new AntPathRequestMatcher(re.getResourceName()),configAttributeList); //LinkedHashMap<RequestMatcher, List<ConfigAttribute>>  해당포맷으로 추가한다.
            });
        });

        return result;
    }
}