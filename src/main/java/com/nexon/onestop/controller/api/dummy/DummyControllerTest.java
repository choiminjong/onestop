package com.nexon.onestop.controller.api.dummy;

import com.nexon.onestop.domain.entity.*;
import com.nexon.onestop.repository.DelegateRepository;
import com.nexon.onestop.repository.DelegateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DummyControllerTest {

    @Autowired
    private DelegateRepository delegateRepository;

    @Autowired
    private DelegateUserRepository delegateUserRepository;

    @PostMapping("/dummy/setup")
    public String setUp2(){
        Delegate delegate = Delegate.builder()
                .groupname("TeamA")
                .build();
        delegateRepository.save(delegate);

        DelegateUser delegateUser = DelegateUser.builder()
                .username("memeber1")
                .delegate(delegate)
                .build();
        delegateUserRepository.save(delegateUser);
        return "팀추가";
    }

    @PostMapping("/dummy/team/{groupname}")
    public String teamAdd2(@PathVariable String groupname){
        Delegate delegate = Delegate.builder()
                .groupname(groupname)
                .build();

        delegateRepository.save(delegate);
        return "팀추가";
    }

    @PostMapping("/dummy/member/{groupname}/{membername}")
    public String teamMemberAdd2(@PathVariable String groupname,
                                 @PathVariable String membername) {

        Delegate delegateAdd = delegateRepository.findBygroupname(groupname);

        DelegateUser delegateUser = DelegateUser.builder()
                .username(membername)
                .delegate(delegateAdd)
                .build();

        delegateUserRepository.save(delegateUser);

        return "멤버 추가";
    }

    @GetMapping("/dummy/team")
    public List<Delegate> getTeam(){
        List<Delegate> teamsMembers = delegateRepository.findAll();
        return teamsMembers;
    }

}
