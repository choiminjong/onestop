package com.nexon.onestop.controller.view.clip;

import com.nexon.onestop.domain.dto.AccountDto;
import com.nexon.onestop.domain.entity.Account;
import com.nexon.onestop.domain.entity.Role;
import com.nexon.onestop.service.impl.RoleServiceImpl;
import com.nexon.onestop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/clip")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @GetMapping(value="/accounts")
    public String userManagement(Model model,
                                 @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                 @RequestParam(required = false, defaultValue = "") String searchText ){

        Page<Account> accounts = userServiceImpl.getUsers(searchText,pageable);

        int startPage = Math.max(1,accounts.getPageable().getPageNumber() - 8);
        int endPage = Math.min(accounts.getTotalPages(), accounts.getPageable().getPageNumber() + 8);

        model.addAttribute("accounts",accounts);
        model.addAttribute("endPage",endPage);
        model.addAttribute("startPage", startPage);

        return "clip/admin/settings/user/list";
    }


    @GetMapping(value = "/accounts/{id}")
    public String getUser(@PathVariable(value = "id") Long id, Model model) {

        AccountDto accountDto = userServiceImpl.getUser(id);
        List<Role> roleList = roleServiceImpl.getListRoles();

        model.addAttribute("account", accountDto);
        model.addAttribute("roleList", roleList);

        return "clip/admin/settings/user/detail";
    }
}
