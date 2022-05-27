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
public class ClipController {

    @GetMapping({"/",""})
    public String clip(){
        return "clip/admin/index";
    }

    @GetMapping("/svnManagement")
    public String svnManagement(){
        return "clip/admin/administrators/svnManagement";
    }

    @GetMapping("/confluenceManagement")
    public String confluenceManagement(){
        return "clip/admin/administrators/confluenceManagement";
    }

    @GetMapping("/jiraManagement")
    public String jiraManagement(){
        return "clip/admin/administrators/jiraManagement";
    }


    @GetMapping("/groupManagement")
    public String groupManagement(){
        return "clip/admin/settings/groupManagement";
    }

    @GetMapping("/roleManagement")
    public String roleManagement(){
        return "clip/admin/settings/roleManagement";
    }

    @GetMapping("/resourceManagement")
    public String resourceManagement(){
        return "clip/admin/settings/resourceManagement";
    }

    @GetMapping("/employeeManagement")
    public String employeeManagement(){
        return "clip/admin/settings/employeeManagement";
    }

}
