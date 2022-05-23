package com.nexon.onestop.controller.view.clip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/userManagement")
    public String userManagement(){
        return "clip/admin/settings/userManagement";
    }

    @GetMapping("/employeeManagement")
    public String employeeManagement(){
        return "clip/admin/settings/employeeManagement";
    }



}
